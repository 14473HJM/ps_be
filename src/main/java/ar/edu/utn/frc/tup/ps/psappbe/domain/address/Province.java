package ar.edu.utn.frc.tup.ps.psappbe.domain.address;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Province {

    B("Buenos Aires"),
    K("Catamarca"),
    H("Chaco"),
    U("Chubut"),
    C("Ciudad Autónoma de Buenos Aires"),
    W("Corrientes"),
    X("Córdoba"),
    E("Entre Ríos"),
    P("Formosa"),
    Y("Jujuy"),
    L("La Pampa"),
    F("La Rioja"),
    M("Mendoza"),
    N("Misiones"),
    Q("Neuquén"),
    R("Río Negro"),
    A("Salta"),
    J("San Juan"),
    D("San Luis"),
    Z("Santa Cruz"),
    S("Santa Fe"),
    G("Santiago del Estero"),
    V("Tierra del Fuego"),
    T("Tucumán");

    private String name;
}
