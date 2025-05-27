package loja.com.example.LojaApi.instrutor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import loja.com.example.LojaApi.usuarios.UserEntity;
import loja.com.example.LojaApi.usuarios.UserRepository;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Instrutor salvar(Instrutor instrutorDto) { // Renamed parameter to avoid confusion
        Long userId = instrutorDto.getUsuario().getId();
        System.out.println("Tentando salvar instrutor para usuário ID: " + userId);

        // Verifica se já existe um instrutor para esse usuário
        if (instrutorRepository.existsById(userId)) {
            throw new RuntimeException("Instrutor já existe para o usuário com ID: " + userId);
        }

        // Busca o usuário real no banco para associação
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + userId));

        // Cria um novo objeto Instrutor
        Instrutor novoInstrutor = new Instrutor();
        
        // Define o usuário. @MapsId na entidade Instrutor deve garantir que 
        // o ID do novoInstrutor seja derivado do userEntity.
        novoInstrutor.setUsuario(userEntity); 
        
        // Define os outros campos a partir do DTO/requisição
        novoInstrutor.setRegistroProfissional(instrutorDto.getRegistroProfissional());
        novoInstrutor.setHorarioDisponivel(instrutorDto.getHorarioDisponivel());
        novoInstrutor.setEspecializacao(instrutorDto.getEspecializacao());

        // O ID do novoInstrutor deve agora ser o mesmo que userEntity.getId()
        // System.out.println("ID do novoInstrutor antes de salvar (derivado via @MapsId): " + novoInstrutor.getId());

        try {
            // Tenta salvar. Se o problema persistir, pode ser necessário usar EntityManager.persist()
            // para forçar uma operação de inserção.
            Instrutor instrutorSalvo = instrutorRepository.saveAndFlush(novoInstrutor);
            System.out.println("Instrutor salvo com sucesso! ID: " + instrutorSalvo.getId() + ", Usuário ID associado: " + instrutorSalvo.getUsuario().getId());
            return instrutorSalvo;
        } catch (Exception e) {
            System.err.println("Erro ao salvar instrutor: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw para que o controller possa lidar com isso
        }
    }

    public List<Instrutor> listarTodos() {
        return instrutorRepository.findAll();
    }

    public Optional<Instrutor> buscarPorId(Long id) {
        return instrutorRepository.findById(id);
    }

    public void deletar(Long id) {
        instrutorRepository.deleteById(id);
    }

    public Optional<Instrutor> buscarPorUsuario(Long usuarioId) {
        // Certifique-se que o método no repositório é findById se o ID do instrutor é o mesmo que o usuarioId
        // ou findByUsuario_Id se estiver buscando pelo campo usuario.id
        return instrutorRepository.findById(usuarioId); // Assumindo que o ID do instrutor é o usuarioId
    }
}