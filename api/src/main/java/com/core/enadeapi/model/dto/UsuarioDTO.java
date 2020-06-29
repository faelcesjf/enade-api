package com.core.enadeapi.model.dto;


import com.core.enadeapi.model.TbUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long idUsuario;
    private String nomeUsuario;
    private String emailUsuario;

    private Integer idTipoUsuario;

    private String nomeTipoUsuario;

    public UsuarioDTO(TbUsuario obj){
        this.idUsuario = obj.getIdUsuario();
        this.nomeUsuario = obj.getNomeUsuario();
        this.emailUsuario = obj.getEmailUsuario();
        this.idTipoUsuario = obj.getTbTipoUsuarioidTipoUsuario().getIdTipoUsuario();
        this.nomeTipoUsuario = obj.getTbTipoUsuarioidTipoUsuario().getNomeTipoUsuario();

    }



}
