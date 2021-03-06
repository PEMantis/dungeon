package org.mafagafogigante.dungeon.world;

import org.mafagafogigante.dungeon.entity.creatures.Observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The sky of a world.
 */
public class Sky implements Serializable {

  private final Collection<AstronomicalBody> astronomicalBodies = new ArrayList<>();

  /**
   * Constructs an empty sky.
   */
  Sky() {
  }

  /**
   * Adds an astronomical body to the sky.
   */
  public void addAstronomicalBody(AstronomicalBody astronomicalBody) {
    astronomicalBodies.add(astronomicalBody);
  }

  /**
   * Returns a description of the sky with all its visible features.
   */
  public String describeYourself(Observer observer) {
    StringBuilder stringBuilder = new StringBuilder();
    for (AstronomicalBody astronomicalBody : astronomicalBodies) {
      if (astronomicalBody.isVisible(observer)) {
        if (stringBuilder.length() != 0) {
          stringBuilder.append(' ');
        }
        stringBuilder.append(astronomicalBody.describeYourself());
      }
    }
    return stringBuilder.toString();
  }

  @Override
  public String toString() {
    return "Sky{astronomicalBodies=" + astronomicalBodies + '}';
  }

}
