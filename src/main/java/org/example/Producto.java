package org.example;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private String idProducto;
    private String nombreProducto;
    private Double precioProducto;
    private String descripcionProducto;
    private Integer cantidadProducto;
    private String tipoProducto;
}
