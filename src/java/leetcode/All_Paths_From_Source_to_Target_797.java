package java.leetcode;

import org.junit.Test;

import java.util.*;

public class All_Paths_From_Source_to_Target_797
{
  @Test
  public void test_1()
  {
    int[][] nodes = new int[4][];
    nodes[0] = new int[2];
    nodes[0][0] = 1;
    nodes[0][1] = 2;
    nodes[1] = new int[1];
    nodes[1][0] = 3;
    nodes[2] = new int[1];
    nodes[2][0] = 3;
    nodes[3] = new int[]{};

    System.out.println(allPathsSourceTarget(nodes));
  }

  int[][] graph;

  Set<Integer> goodNodes = new HashSet<>();
  Set<Integer> badNodes = new HashSet<>();

  List<List<Integer>> result = new ArrayList<>();
  public List<List<Integer>> allPathsSourceTarget(int[][] graph)
  {
    this.graph = graph;
    findPath(Collections.emptyList(), 0);
    return result;
  }

  private void findPath(List<Integer> walkedNodes, int nextNode)
  {
    if (graph[nextNode] == null)
    {
      return;
    }

    List<Integer> curPath = new ArrayList<>(walkedNodes);
    curPath.add(nextNode);
    // reached target
    if (nextNode == graph.length-1)
    {
      goodNodes.addAll(curPath);
      result.add(curPath);
      return;
    }
    // detect a loop
    if (walkedNodes.contains(nextNode))
    {
      return;
    }
    // find next steps
    for (int i = 0; i < graph[nextNode].length; i++)
    {
      findPath(curPath, graph[nextNode][i]);
    }
  }
}
