package com.tg.themeparkride.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
public class ThemeParkRidesEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String description;
  private int thrill_factor;
  private int vomit_factor;

  public ThemeParkRidesEntity() {
	  
  }
  
  public ThemeParkRidesEntity(String name, String description, int thrill_factor, int vomit_factor) {
      this.name = name;
      this.description = description;
      this.setThrill_factor(thrill_factor);
      this.setVomit_factor(vomit_factor);
  }

public int getThrill_factor() {
	return thrill_factor;
}

public void setThrill_factor(int thrill_factor) {
	this.thrill_factor = thrill_factor;
}

public int getVomit_factor() {
	return vomit_factor;
}

public void setVomit_factor(int vomit_factor) {
	this.vomit_factor = vomit_factor;
}

}

