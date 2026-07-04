package com.makingbigger.portafoliojmc.domain.informacionpersonal;

import com.makingbigger.portafoliojmc.domain.redessociales.RedesSociales;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "informacion_personal")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InformacionPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nombre;
    private String apellido;
    private String titulo;
    private String subtitulo;
    private String resumen;
    private String correoElectronico;
    private String telefono;
    private String ubicacion;
    private String urlFoto;
    private String urlCv;
    private String disponibilidad;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RedesSociales> redesSociales;
}
