package com.smart.common.domain.beden;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.smart.common.domain.base.BaseEntity;

@Table(name = "beden_tipi", schema = "postgres")
@Entity
public class BedenTipi extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_beden_tipi")
    @SequenceGenerator(name = "seq_beden_tipi", sequenceName = "seq_beden_tipi", allocationSize = 1,initialValue=1)
    private Long id;

    @NotNull
    @Column(nullable=false, length=40)
    private String adi;
    @NotNull
    @Column(nullable=false, length=10)
    private String kodu;
    @NotNull
    @Column(nullable=false, length=10)
    private String descriptionString;

    @NotNull
    @Column(nullable=false)
    private Boolean active;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getAdi() {
      return adi;
    }

    public void setAdi(String adi) {
      this.adi = adi;
    }

    public String getKodu() {
      return kodu;
    }

    public void setKodu(String kodu) {
      this.kodu = kodu;
    }

    public Boolean getActive() {
      return active;
    }

    public void setActive(Boolean active) {
      this.active = active;
    }

    public String getDescriptionString() {
      return descriptionString;
    }

    public void setDescriptionString(String descriptionString) {
      this.descriptionString = descriptionString;
    }
  
}