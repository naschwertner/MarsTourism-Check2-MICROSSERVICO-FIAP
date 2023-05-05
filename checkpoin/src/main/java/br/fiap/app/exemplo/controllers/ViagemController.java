package br.fiap.app.exemplo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.fiap.app.exemplo.models.Viagem;
import br.fiap.app.exemplo.service.*;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping("/")
    public String listar(Model model) {
        List<Viagem> viagens = viagemService.listarViagens();
        model.addAttribute("viagens", viagens);
        return "listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("viagem", new Viagem());
        return "novo";
    }

    @PostMapping("/salvar")
    public String salvar(@jakarta.validation.Valid Viagem viagem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "novo";
        }
        viagemService.cadastrarViagem(viagem);
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        viagemService.excluirViagem(id);
        return "redirect:/"; // Altere esta linha
    }

    // Adicionando a função editar
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Viagem viagem = viagemService.buscarViagemPorId(id);
        model.addAttribute("viagem", viagem);
        return "editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(@jakarta.validation.Valid Viagem viagem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editar";
        }
        viagemService.atualizarViagem(viagem);
        return "redirect:/";
    }
}
