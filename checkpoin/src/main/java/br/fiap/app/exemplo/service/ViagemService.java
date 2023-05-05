package br.fiap.app.exemplo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fiap.app.exemplo.models.Viagem;
import br.fiap.app.exemplo.repositories.ViagemRepository;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    public List<Viagem> listarViagens() {
        return viagemRepository.findAll();
    }

    public Viagem cadastrarViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public Optional<Viagem> buscarViagem(Long id) {
        return viagemRepository.findById(id);
    }

    public void excluirViagem(Long id) {
        viagemRepository.deleteById(id);
    }

    public Viagem alterarViagem(Long id, Viagem viagem) throws Exception {
        Optional<Viagem> optionalViagem = viagemRepository.findById(id);
        if (optionalViagem.isPresent()) {
            Viagem viagemAtual = optionalViagem.get();
            BeanUtils.copyProperties(viagem, viagemAtual, "id");
            return viagemRepository.save(viagemAtual);
        } else {
            throw new Exception("Viagem não encontrada");
        }
    }

    public LocalDate calcularDataRetorno(Viagem viagem) {
        return viagem.getDataDecolagem().plusDays(viagem.getDuracaoEstadia() * 2 + 180);
    }

    // Adicionando os métodos buscarViagemPorId e atualizarViagem
    public Viagem buscarViagemPorId(Long id) {
        Optional<Viagem> optionalViagem = viagemRepository.findById(id);
        if (optionalViagem.isPresent()) {
            return optionalViagem.get();
        } else {
            throw new RuntimeException("Viagem não encontrada");
        }
    }

    public Viagem atualizarViagem(Viagem viagem) {
        return viagemRepository.save(viagem);
    }
}
