package com.javacloud.codewar;

import java.util.ArrayList;
import java.util.List;

public class Warrior {

  public Warrior() {
    this.experience = 100;
  }

  private static final String[] rankName =
      new String[] {
        "Pushover",
        "Novice",
        "Fighter",
        "Warrior",
        "Veteran",
        "Sage",
        "Elite",
        "Conqueror",
        "Champion",
        "Master",
        "Greatest"
      };
  private int experience;
  private List<String> achievements = new ArrayList<>();

  public String battle(int enemyLevel) {
    if (enemyLevel < 1) {
      return "Invalid level";
    }
    if (enemyLevel - level() > 5) {
      if (!rank().equals(getRank(enemyLevel))) {
        return "You've been defeated";
      }
    }
    int tempLevel = level();
    earnExperience(enemyLevel);
    if (enemyLevel >= tempLevel) {
      return "An intense fight";
    }
    if (enemyLevel - tempLevel < -1) {
      return "Easy fight";
    }
    return "A good fight";
  }

  private void earnExperience(int enemyLevel) {

    int newExperience = this.experience;
    if (level() == enemyLevel) {
      newExperience += 10;
    }
    if (level() - enemyLevel == 1) {
      newExperience += 5;
    }
    if (enemyLevel > level()) {
      newExperience += 20 * Math.pow((enemyLevel - level()), 2);
    }
    this.experience = Math.min(newExperience, 10000);
  }

  public void initLevel(int i) {
    this.experience = i * 100;
  }

  public int experience() {
    return experience;
  }

  public String rank() {
    return getRank(level());
  }

  private String getRank(int level) {
    if (level > 100) {
      return rankName[9];
    }
    return rankName[level / 10];
  }

  public int level() {
    return Math.min(this.experience / 100, 100);
  }

  public String training(String info, int trainingExp, int levelRequirement) {
    if (level() < levelRequirement) {
      return "Not strong enough";
    }
    this.experience = Math.min(this.experience + trainingExp, 10000);
    achievements.add(info);
    return info;
  }

  public List<String> achievements() {
    return achievements;
  }
}
