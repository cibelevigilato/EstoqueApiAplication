package cibele.diva.EstoqueApiAplication.api.controller;

import cibele.diva.EstoqueApiAplication.domain.DTO.MaiorSaidaDTO;
import cibele.diva.EstoqueApiAplication.domain.DTO.MovimentoDTO;
import cibele.diva.EstoqueApiAplication.domain.DTO.RelatorioPeriodoDTO;
import cibele.diva.EstoqueApiAplication.domain.model.Movimento;
import cibele.diva.EstoqueApiAplication.domain.repository.MovimentoRepository;
import cibele.diva.EstoqueApiAplication.domain.service.MovimentoService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */
@RestController
@RequestMapping("/movto")
public class MovimentoController {

    @Autowired
    private MovimentoService movtoService;

    @Autowired
    private MovimentoRepository movtoRepository;

    @PostMapping
    public ResponseEntity<Movimento> atualizaSaldo(@RequestBody @Valid MovimentoDTO movtoDTO) {
        Movimento newMovimento = movtoService.atualizaSaldo(movtoDTO.getIdProduto(), movtoDTO.getQuantidade());

        return ResponseEntity.status(HttpStatus.CREATED).body(newMovimento);
    }

    // listar histtorico de saidas em ordem decrescente por data
    @GetMapping("/saidas")
    public List<Movimento> listarSaidasDecrescene() {
        return movtoRepository.findByQtdLessThanOrderByDataMovtoDesc(0.0);
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<RelatorioPeriodoDTO>> obterRelatorio(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {

        // Converte LocalDate para LocalDateTime para manter a compatibilidade com a consulta do Repositório
        LocalDateTime inicio = (dataInicio != null) ? dataInicio.atStartOfDay() : null;
        LocalDateTime fim = (dataFim != null) ? dataFim.atTime(23, 59, 59) : null;

        List<RelatorioPeriodoDTO> relatorio = movtoService.findRelatorioEstoqueViaJPQL(inicio, fim);
        return ResponseEntity.ok(relatorio);
    }

}
    
    
    //@GetMapping("/maiores-saidas")
    //public ResponseEntity<List<MaiorSaidaDTO>> obterMaioresSaidas(
           // @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            //@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
            
            //LocalDateTime inicio = (dataInicio != null) ? dataInicio.atStartOfDay(); null;
            
            
            




//}*\
