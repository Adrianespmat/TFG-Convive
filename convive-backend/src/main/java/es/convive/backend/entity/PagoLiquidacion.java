package es.convive.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "liquidaciones")
public class PagoLiquidacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "piso_id", nullable = false, foreignKey = @ForeignKey(name = "fk_liquidaciones_piso"))
    private Piso piso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pagador_usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_liquidaciones_pagador"))
    private Usuario pagador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receptor_usuario_id", nullable = false, foreignKey = @ForeignKey(name = "fk_liquidaciones_receptor"))
    private Usuario receptor;

    @NotNull
    @DecimalMin(value = "0.01")
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal importe;

    @NotNull
    @Column(nullable = false)
    private LocalDate fecha;

    protected PagoLiquidacion() { }

    public PagoLiquidacion(Piso piso, Usuario pagador, Usuario receptor, BigDecimal importe, LocalDate fecha) {
        this.piso = piso;
        this.pagador = pagador;
        this.receptor = receptor;
        this.importe = importe;
        this.fecha = fecha;
    }

    public Long getId() { return id; }
    public Piso getPiso() { return piso; }
    public Usuario getPagador() { return pagador; }
    public Usuario getReceptor() { return receptor; }
    public BigDecimal getImporte() { return importe; }
    public LocalDate getFecha() { return fecha; }
}
