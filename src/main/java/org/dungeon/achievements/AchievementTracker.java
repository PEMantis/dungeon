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

import java.io.Serializable;
import java.util.ArrayList;

/**
 * AchievementTracker that tracks the unlocked achievements.
 * <p/>
 * Created by Bernardo Sulzbach on 16/11/14.
 */
public class AchievementTracker implements Serializable {

    private final ArrayList<String> unlockedAchievements;

    public AchievementTracker() {
        this.unlockedAchievements = new ArrayList<String>();
    }

    public int getUnlockedCount() {
        return unlockedAchievements.size();
    }

    public void setUnlocked(Achievement achievement) {
        unlockedAchievements.add(achievement.getId());
    }

    public boolean isUnlocked(Achievement achievement) {
        return unlockedAchievements.contains(achievement.getId());
    }

}