package com.core.enadeapi.services;


import com.core.enadeapi.model.*;
import com.core.enadeapi.model.dto.QuestaoAbertaDTO;
import com.core.enadeapi.model.dto.RespostaDTO;
import com.core.enadeapi.model.repository.QuestaoRepository;
import com.core.enadeapi.model.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultadoService {

    @Autowired
    public QuestaoRepository questaoRepository;

    @Autowired
    public ResultadoRepository repository;


    public double calculaNota(List<RespostaDTO> respostas){
        int nota = 0;
        for (RespostaDTO resposta :respostas) {
            TbQuestao questao = questaoRepository.findOne(resposta.getIdQuestao());
            if(questao.getTbTipoQuestaoidTipoQuestao().getNomeTipoQuestaocol() == "Aberta"){
                nota++;
            }
            else if (questao.getTbTipoQuestaoidTipoQuestao().getNomeTipoQuestaocol() == "Fechada"){
               Character correta = questao.getQuestaoCorreta() ;
               Character marcado = resposta.getAlternativaMarcada();
               if(correta == marcado){
                   nota++;
               }

            }



        }
        return nota;




    }

    public TbResultado salvar(TbResultado resultado){
        return repository.save(resultado);
    }

    public TbResultado fromDTO(List<RespostaDTO> respostas) {
        TbResultado resultado =  new TbResultado();
        TbUsuario usuario = new TbUsuario();
        TbProva prova = new TbProva();

        resultado.setValorObtido(this.calculaNota(respostas));
        usuario.setIdUsuario(respostas.get(0).getIdALuno());
        prova.setIdProva(respostas.get(0).getIdProva());
        resultado.setTbUsuarioidUsuario(usuario);
        resultado.setTbProvaidProva(prova);

        return resultado;
    }

}
