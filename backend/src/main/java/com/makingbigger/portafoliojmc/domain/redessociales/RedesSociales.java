package com.makingbigger.portafoliojmc.domain.redessociales;

import com.makingbigger.portafoliojmc.domain.informacionpersonal.InformacionPersonal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Table(name = "redes_sociales")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedesSociales {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String plataforma;
    private String url;
    private String icono;
    private String etiqueta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informacion_personal_id")
    private InformacionPersonal perfil;
}