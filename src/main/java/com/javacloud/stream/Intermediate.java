package com.javacloud.stream;

import static com.google.common.collect.Lists.newArrayList;

import com.javacloud.stream.Intermediate.ParentFloor.ChildFloor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.Setter;

public class Intermediate {
  private Stream<String> testStream =
      newArrayList("apple", "banana", "claw", "dog", "egg", "flow").stream();

  public void filter() {
    List<Integer> l =
        IntStream.range(1, 10)
            .filter(i -> i % 2 == 0)
            .boxed()
            .collect(Collectors.toList()); // [2, 4, 6, 8]
  }

  public void map() {
    List<Integer> l =
        Stream.of('a', 'b', 'c')
            .map(c -> c.hashCode())
            .collect(Collectors.toList()); // [97, 98, 99]
    ProjectDesigniteScanInfo.getModules() // List<ModuleDesigniteScanInfo>
        .stream()
        .map(ModuleDesigniteScanInfo::findCycleInClassGraph) // List<List<List<SM_Type>>>
        .flatmap(List::stream) // List<List<SM_Type>>
        .map(
            classCycle ->
                ClassCircularDependencyInfo.createEmpty(serviceId, serviceName)
                    .bindCircularClass(classCycle)) // Stream<ClassCircularDependencyInfo>
        .collect(Collectors.toList()); // List<ClassCircularDependencyInfo>

    newArrayList().stream()
        .max(
            (pre, next) -> {
              int preTotalDegree = pre.getInDegree() + pre.getOutDegree();
              int nextTotalDegree = next.getInDegree() + next.getOutDegree();
              return Integer.compare(preTotalDegree, nextTotalDegree);
            })
        .map(
            parentFloor -> {
              List<String> childrenName =
                  ParentFloors.stream()
                      .flatMap(
                          parent -> {
                            String prefix = parent.getName + ".";
                            return Stream.concat(
                                    parent.getConnectChildFloors().stream(),
                                    parent.getNotConnectChildFloors().stream)
                                .map(child -> prefix + child.getName());
                          });
              return CircularDependencySuggestion.createMergeSuggestion(parentFloor, childrenName);
            })
        .orElseThrow(new BusinessException());
  }

  public void scenesOne() {
    List<ModuleDesigniteScanInfo> moduleDesigniteScanInfos = ProjectDesigniteScanInfo.getModules();
    List<ClassCircularDependencyInfo> classCircularDependencyInfos = newArrayList();
    for (ModuleDesigniteScanInfo moduleDesigniteScanInfo : moduleDesigniteScanInfos) {
      List<List<SM_Type>> classCycle = moduleDesigniteScanInfo.findCycleInClassGraph();
      ClassCircularDependencyInfo dependencyInfo =
          ClassCircularDependencyInfo.createEmpty("serviceId", "serviceName");
      dependencyInfo.bindCircularClass(classCycle);
      classCircularDependencyInfos.add(dependencyInfo);
    }
  }

  public CircularDependencySuggestion scenesTwo() {
    List<ParentFloor> parentFloors = newArrayList();
    if (parentFloors == null || parentFloors.size() == 0) {
      throw new BusinessException();
    }
    ParentFloor maxDegreeParentFloor = parentFloors.get(0);
    if (parentFloors.size() > 1) {
      for (int i = 1; i < parentFloors.size(); i++) {
        ParentFloor parentFloor = parentFloors.get(i);
        int nowDegree = parentFloor.getIntDegree() + parentFloor.getOutDegree();
        int maxDegree = maxDegreeParentFloor.getIntDegree() + maxDegreeParentFloor.getOutDegree();
        if (nowDegree > maxDegree) {
          maxDegreeParentFloor = parentFloor;
        }
      }
    }
    List<String> childrenName = newArrayList();
    for (int i = 0; i < parentFloors.size(); i++) {
      ParentFloor parentFloor = parentFloors.get(i);
      List<ChildFloor> childFloors = parentFloor.getConnectChildFloors();
      childFloors.addAll(parentFloor.getNotConnectChildFloors());
      for (int j = 0; j < childFloors.size(); j++) {
        childrenName.add(parentFloor.getName() + "." + childFloors.get(j).name);
      }
    }
    return CircularDependencySuggestion.createMergeSuggestion(maxDegreeParentFloor, childrenName);
  }

  @Getter
  @Setter
  public class ParentFloor {
    private String name;
    private int outDegree;
    private int intDegree;
    private List<ChildFloor> connectChildFloors;
    private List<ChildFloor> notConnectChildFloors;

    private class ChildFloor {
      private String name;
    }
  }

  public void flatMap() {
    String poetry =
        "Where, before me, are the ages that have gone?\n"
            + "And where, behind me, are the coming generations?\n"
            + "I think of heaven and earth, without limit, without end,\n"
            + "And I am all alone and my tears fall down.";
    Stream<String> lines = Arrays.stream(poetry.split("\n"));
    Stream<String> words = lines.flatMap(line -> Arrays.stream(line.split(" ")));
    List<String> l =
        words
            .map(
                w -> {
                  if (w.endsWith(",") || w.endsWith(".") || w.endsWith("?"))
                    return w.substring(0, w.length() - 1).trim().toLowerCase();
                  else return w.trim().toLowerCase();
                })
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    System.out.println(
        l); // [ages, all, alone, am, and, are, before, behind, coming, down, earth, end, fall,
    // generations, gone, have, heaven, i, limit, me, my, of, tears, that, the, think,
    // where, without]
  }

  public void sorted() {
    String[] arr = new String[] {"b_123", "c+342", "b#632", "d_123"};
    List<String> l =
        Arrays.stream(arr)
            .sorted(
                (s1, s2) -> {
                  if (s1.charAt(0) == s2.charAt(0))
                    return s1.substring(2).compareTo(s2.substring(2));
                  else return s1.charAt(0) - s2.charAt(0);
                })
            .collect(Collectors.toList()); // [b_123, b#632, c+342, d_123]
  }

  public void distinct() {
    List<String> l =
        Stream.of("a", "b", "c", "b").distinct().collect(Collectors.toList()); // [a, b, c]
  }

  public void limit() {
    List<Integer> l =
        IntStream.range(1, 100).limit(5).boxed().collect(Collectors.toList()); // [1, 2, 3, 4, 5]
  }

  public void peek() {
    String[] arr = new String[] {"a", "b", "c", "d"};
    Arrays.stream(arr)
        .peek(System.out::println) // a,b,c,d
        .count();
  }

  public void reduce() {
    // 字符串连接，concat = "ABCD"
    String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
    // 求最小值，minValue = -3.0
    double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
    // 求和，sumValue = 10, 有起始值
    int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
    // 求和，sumValue = 10, 无起始值
    sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
    // 过滤，字符串连接，concat = "ace"
    concat =
        Stream.of("a", "B", "c", "D", "e", "F")
            .filter(x -> x.compareTo("Z") > 0)
            .reduce("", String::concat);
  }

  public void limitAndSkip() {
    List<User> users =
        IntStream.rangeClosed(0, 10000)
            .mapToObj(idx -> new User(idx, "name" + idx))
            .collect(Collectors.toList());
    List<String> personList2 =
        users.stream().map(User::getName).limit(10).skip(3).collect(Collectors.toList());
    System.out.println(personList2);
    List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
    Set<Type> types = users.stream().map(User::getType).collect(Collectors.toSet());
    Map<Type, User> byType =
        users.stream().collect(Collectors.toMap(User::getType, Function.identity()));
    Map<Type, List<User>> groupby = users.stream().collect(Collectors.groupingBy(User::getType));
    HashMap<String, User> splitByGroup =
        users.stream()
            .collect(
                Collector.of(
                    () -> new HashMap<String, User>(),
                    (user1, user2) -> {
                      user1.put(user2.getGroup(), user2);
                    },
                    (left, right) -> {
                      right.entrySet().stream()
                          .forEach(entry -> left.put(entry.getKey(), entry.getValue()));
                      return left;
                    }));
  }

  private static class User {

    public User(String str) {}

    public User(int i, String s) {}

    public String getGroup() {
      return "group";
    }

    public int getAge() {
      return new Random().nextInt();
    }

    public static String getName(User user) {
      return null;
    }

    public static Type getType(User user) {
      return new Type();
    }
  }

  private static class Type {}

  private static class ProjectDesigniteScanInfo {

    public static List<ModuleDesigniteScanInfo> getModules() {
      return null;
    }
  }

  private class ModuleDesigniteScanInfo {

    public List<List<SM_Type>> findCycleInClassGraph() {
      return null;
    }
  }

  private class SM_Type {}

  private static class ClassCircularDependencyInfo {

    public static ClassCircularDependencyInfo createEmpty(String serviceId, String serviceName) {}

    public void bindCircularClass(List<List<SM_Type>> classCycle) {}
  }

  private static class CircularDependencySuggestion {

    public static CircularDependencySuggestion createMergeSuggestion(
        ParentFloor parentFloor, List<String> childrenName) {
      return null;
    }
  }

  private class BusinessException extends RuntimeException {}
}
