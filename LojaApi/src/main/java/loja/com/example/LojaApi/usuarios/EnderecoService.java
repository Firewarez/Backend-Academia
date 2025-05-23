package loja.com.example.LojaApi.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UserRepository userRepository;

    public EnderecoEntity salvar(Long usuarioId, EnderecoEntity endereco) {
        UserEntity usuario = userRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + usuarioId));
        endereco.setUsuario(usuario);
        return enderecoRepository.save(endereco);
    }

    public List<EnderecoEntity> listarPorUsuario(Long usuarioId) {
        return enderecoRepository.findByUsuarioId(usuarioId);
    }

    public Optional<EnderecoEntity> buscarPorId(Long id) {
        return enderecoRepository.findById(id);
    }

    public void deletar(Long id) {
        enderecoRepository.deleteById(id);
    }
}
