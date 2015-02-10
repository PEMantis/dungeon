/*
 * Copyright (C) 2014 Bernardo Sulzbach
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.dungeon.achievements;

import org.dungeon.game.Game;
import org.dungeon.game.ID;
import org.dungeon.stats.ExplorationStatistics;
import org.dungeon.util.CounterMap;

/**
 * The exploration component of the achievements.
 * <p/>
 * Created by Bernardo on 07/12/2014.
 */
final class ExplorationComponent {

  /**
   * Stores how many kills in Locations with a specified ID the Hero must have.
   */
  final CounterMap<ID> killsByLocationID;

  /**
   * Stores how many distinct Locations with a specified ID the Hero must visit.
   */
  final CounterMap<ID> distinctLocationsVisitCount;

  /**
   * Stores how many times the Hero must visit the same Location with a specified ID.
   */
  final CounterMap<ID> sameLocationVisitCounter;

  ExplorationComponent(CounterMap<ID> killsByLocationID, CounterMap<ID> distinctLocationsVisitCount,
      CounterMap<ID> sameLocationVisitCounter) {
    this.killsByLocationID = killsByLocationID;
    this.distinctLocationsVisitCount = distinctLocationsVisitCount;
    this.sameLocationVisitCounter = sameLocationVisitCounter;
  }

  /**
   * Checks if this component of the Achievement is fulfilled or not.
   */
  public boolean isFulfilled() {
    ExplorationStatistics statistics = Game.getGameState().getStatistics().getExplorationStatistics();
    if (killsByLocationID != null) {
      for (ID locationID : killsByLocationID.keySet()) {
        if (statistics.getKillCount(locationID) < killsByLocationID.getCounter(locationID)) {
          return false;
        }
      }
    }
    if (distinctLocationsVisitCount != null) {
      for (ID locationID : distinctLocationsVisitCount.keySet()) {
        if (statistics.getDistinctVisitCount(locationID) < distinctLocationsVisitCount.getCounter(locationID)) {
          return false;
        }
      }
    }
    if (sameLocationVisitCounter != null) {
      for (ID locationID : sameLocationVisitCounter.keySet()) {
        if (statistics.getSameLocationVisitCount(locationID) < sameLocationVisitCounter.getCounter(locationID)) {
          return false;
        }
      }
    }
    return true;
  }

}
