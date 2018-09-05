package leetcode;

import org.junit.Test;

import java.util.*;

public class All_Paths_From_Source_to_Target_797_2
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

  // node, path to target
  Map<Integer, List<List<Integer>>> goodPaths = new HashMap();

  public List<List<Integer>> allPathsSourceTarget(int[][] graph)
  {
    this.graph = graph;
    return findPath(Collections.emptyList(), 0);
  }

  private List<List<Integer>> findPath(List<Integer> walkedNodes, int node)
  {
    if (graph[node] == null)
    {
      return Collections.emptyList();
    }

    List<Integer> curPath = new ArrayList<>(walkedNodes);
    curPath.add(node);
    // reached target
    if (node == graph.length - 1)
    {
      List<List<Integer>> result = new ArrayList<>();
      result.add(curPath);
      return result;
    }
    // find next steps
    List<List<Integer>> results = new ArrayList<>();
    for (int i = 0; i < graph[node].length; i++)
    {
      int nextNode = graph[node][i];
      // detect a loop
      if (walkedNodes.contains(nextNode))
      {
        continue;
      }
      if (goodPaths.containsKey(nextNode))
      {
        for (List<Integer> goodSubPath : goodPaths.get(nextNode))
        {
          List<Integer> goodPath = new ArrayList<>(curPath);
          goodPath.addAll(goodSubPath);
          results.add(goodPath);
        }
      }
      else
      {
        results.addAll(findPath(curPath, nextNode));
      }
    }
    // fill successful node paths
    if (!goodPaths.containsKey(node))
    {
      List<List<Integer>> nodePaths = new ArrayList<>();
      for (List<Integer> result : results)
      {
        List<Integer> nodePath = result.subList(curPath.size() - 1, result.size());
        nodePaths.add(nodePath);
      }
      goodPaths.put(node, nodePaths);
    }

    return results;
  }
}
