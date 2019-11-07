package by.mironenka.collections.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GraphTest {

    private Graph graph;
    String you;
    String alice;
    String anuj;
    String bob;
    String clair;
    String johny;
    String peggi;
    String tom;

    @Before
    public void init() {
        graph = new Graph();

        you = "you";
        alice = "Alice";
        anuj = "Anuj";
        bob = "Bob";
        clair = "Clair";
        johny = "Johny";
        peggi = "Peggi";
        tom = "Tom";

        graph.addVertex(you);
        graph.addVertex(alice);
        graph.addVertex(anuj);
        graph.addVertex(bob);
        graph.addVertex(clair);
        graph.addVertex(johny);
        graph.addVertex(peggi);
        graph.addVertex(tom);
        graph.addEdge(you, alice);
        graph.addEdge(you, bob);
        graph.addEdge(you, clair);
        graph.addEdge(alice, peggi);
        graph.addEdge(bob, peggi);
        graph.addEdge(bob,anuj);
        graph.addEdge(clair, tom);
        graph.addEdge(clair, johny);
    }

    @Test
    public void whenMangoSellerIsTomThenReturnTom() {
        String result = graph.breadthFirstTraversal(graph, you);
        assertThat(result, is(tom));
    }

    @Test
    public void whenGetNeighborsOfYou() {
        List<String> result = new ArrayList<>();
        graph.getAdjVertices(you).stream().forEach(e -> result.add(e.getLabel()));
        List<String> checked = List.of(alice, bob, clair);
        assertThat(result, is(checked));
    }

    @Test
    public void whenGetNeighborsOfBob() {
        List<String> result = new ArrayList<>();
        graph.getAdjVertices(bob).stream().forEach(e -> result.add(e.getLabel()));
        List<String> checked = List.of(you, peggi, anuj);
        assertThat(result, is(checked));
    }

}