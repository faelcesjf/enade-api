package com.core.enadeapi.model.dto;


import com.core.enadeapi.model.TbResultado;
import com.core.enadeapi.model.TbUsuario;
import lombok.Data;
import java.util.List;

@Data
public class AlunoDTO {

    private static final long serialVersionUID = 1L;

    private Long idUsuario;
    private String nomeUsuario;
    private double nota;

    public AlunoDTO(TbUsuario obj) {

        this.idUsuario = obj.getIdUsuario();
        this.nomeUsuario =  obj.getNomeUsuario();

    }
    public AlunoDTO(TbUsuario obj, Integer idProva) {

        this.idUsuario = obj.getIdUsuario();
        this.nomeUsuario =  obj.getNomeUsuario();
        this.nota = this.getNota(obj.getTbResultadoList(),idProva);


    }

    public double getNota(List<TbResultado> resultados, Integer idprova){

        for (TbResultado resultado:
             resultados) {
            if(resultado.getTbProvaidProva().getIdProva() == idprova){
                return resultado.getValorObtido();
            }

        }
        return new Double(null);

    }

}
