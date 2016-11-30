import ADTs.*;

import java.util.*;

/**
 * Created by patricklanger on 10.11.16.
 */
public class Creator {

    public Nea createNea(Map<Edge, String> edges, List<Node> nodes, Node start, List<Node> targets, List<String> alphabet) {
        Nea nea = new Nea(alphabet);
        for (Node n : nodes) {
            nea.createNode(n.getName());
        }
        nea.addStartNode(start);
        for (Node n:targets) {
            nea.addEndNode(n);
        }
        for (Map.Entry<Edge, String> entry: edges.entrySet()) {
            nea.createEdge(entry.getValue(), entry.getKey().getTargetNode().getName(), entry.getKey().getLiteral());
        }
        return nea;
    }

    public Dea generateDea(Nea nea){
        Dea dea = new Dea(nea.getAlphabet());

        //StartNode erzeugen
        dea.createNode("q0");
        DeaNode startnode = dea.getNodes().get(0);
        for (AbstractNode n: nea.getStartNodes()) {
            startnode.addNodeToZustandsmenge(n);
        }
        dea.setStartNode(startnode);

        //Erstellen von Knoten
        //Solange noch Knoten prouziert werden fahre fort
        boolean somethingChanged = true;
        while (somethingChanged){
            somethingChanged = false;
            for(int i=0; i<dea.getNodes().size(); i++){
                DeaNode node = dea.getNodes().get(i);
                for(String a : dea.getAlphabet()){
                    //Erzeugen eines neuen Knoten
                    DeaNode newDeaNode = new DeaNode("q" + dea.getNodes().size());
                    for(AbstractNode n : node.getZustandsmenge()){
                        for(AbstractEdge e : n.getEdges()){
                            if(e.getLiteral().equals(a)){
                                newDeaNode.addNodeToZustandsmenge(e.getTargetNode());
                            }
                        }
                    }

                    if(!newDeaNode.getZustandsmenge().isEmpty()){
                        //Pruefen ob es diesen Knoten schon gibt
                        Set<AbstractNode> newDeaNodeZustandsmenge = new HashSet<AbstractNode>();
                        newDeaNodeZustandsmenge.addAll(newDeaNode.getZustandsmenge());
                        Set<AbstractNode> deaNodeZustandsmenge = new HashSet<AbstractNode>();

                        boolean newDeaNodeAlreadyExists = false;
                        for(DeaNode deaNode : dea.getNodes()){
                            deaNodeZustandsmenge.clear();
                            deaNodeZustandsmenge.addAll(deaNode.getZustandsmenge());
                            if(newDeaNodeZustandsmenge.containsAll(deaNodeZustandsmenge)
                                    && deaNodeZustandsmenge.containsAll(newDeaNodeZustandsmenge)){
                                newDeaNodeAlreadyExists = true;
                                boolean edgeIsNew = false;
                                for (AbstractEdge e : node.getEdges()){
                                    if(!e.getLiteral().equals(a) || !e.getTargetNode().equals(deaNode)){
                                        node.addEdge(new Edge(deaNode, a));
                                    }
                                }
                                if(node.getEdges().isEmpty()){
                                    node.addEdge(new Edge(deaNode, a));
                                }
                            }
                        }

                        //neuen Knoten erzeugen, sofern es ihn noch nicht gibt
                        if (!newDeaNodeAlreadyExists){
                            dea.addNode(newDeaNode);
                            node.addEdge(new Edge(newDeaNode, a));
                            somethingChanged = true;
                        }
                    }

                }
            }
        }

        //Endzustaende festlegen
        for(DeaNode node : dea.getNodes()){
            for(AbstractNode n : node.getZustandsmenge()){
                if (nea.getEndNodes().contains(n) && !dea.getEndNodes().contains(node)){
                    dea.addEndNode(node);
                }
            }
        }

        return dea;
    }

    public Dea generateDeaKomplement(Dea dea){
        List<DeaNode> nodes = new ArrayList<DeaNode>();
        for(DeaNode node : dea.getNodes()){
            if(!dea.getEndNodes().contains(node)){
                nodes.add(node);
            }
        }
        dea.resetEndNodes(nodes);

        return dea;
    }

    public Dea generateProduktautomat(Nea nea, Dea dea){
        Dea automat = new Dea(dea.getAlphabet());

        //Zustaende erzeugen
        for(AbstractNode neaNode : nea.getNodes()){
            for(DeaNode deaNode : dea.getNodes()){
                DeaNode newNode = new DeaNode(neaNode.getName() + deaNode.getName());
                newNode.addNodeToZustandsmenge(neaNode);
                newNode.addNodeToZustandsmenge(deaNode);
                automat.addNode(newNode);
            }
        }

        //Kanten erzeugen
        for(DeaNode node : automat.getNodes()){
            for(String a : automat.getAlphabet()){
                //mit naechsten 2 Forschleifen: Suche Zielkonten fuer Literal
                for(AbstractEdge edgeA : node.getZustandsmenge().get(0).getEdges()){
                    if (edgeA.getLiteral().equals(a)){
                        for(AbstractEdge edgeB : node.getZustandsmenge().get(1).getEdges()){
                            if(edgeB.getLiteral().equals(a)){
                                //Zielkonten heraussuchen
                                for(DeaNode target : automat.getNodes()){
                                    if (target.getZustandsmenge().contains(edgeA.getTargetNode())
                                            && target.getZustandsmenge().contains(edgeB.getTargetNode())){
                                        node.addEdge(new Edge(target, a));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //Startzustand setzen
        for(DeaNode node : automat.getNodes()){
            if((nea.getStartNodes().contains(node.getZustandsmenge().get(0))
                    && dea.getStartNode().equals(node.getZustandsmenge().get(1)))
                    || (dea.getStartNode().equals(node.getZustandsmenge().get(0))
                    && nea.getStartNodes().contains(node.getZustandsmenge().get(1)))){
                automat.setStartNode(node);
            }
        }

        //Endzustaende setzen
        for(DeaNode node : automat.getNodes()){
            if((nea.getEndNodes().contains(node.getZustandsmenge().get(0))
                    && dea.getEndNodes().contains(node.getZustandsmenge().get(1)))
                    || (dea.getEndNodes().contains(node.getZustandsmenge().get(0))
                    && nea.getEndNodes().contains(node.getZustandsmenge().get(1)))){
                automat.addEndNode(node);
            }
        }

        return automat;
    }

    public boolean isATargetReachable(Dea automat){
        List<AbstractNode> currentNodes = new ArrayList<AbstractNode>();
        List<AbstractNode> nextNodes = new ArrayList<AbstractNode>();
        List<AbstractNode> investigatedNodes = new ArrayList<AbstractNode>();
        currentNodes.add(automat.getStartNode());

        while (!currentNodes.isEmpty()){
            nextNodes.clear();
            for(AbstractNode node : currentNodes){
                for(AbstractEdge edge : node.getEdges()){
                    if (automat.getEndNodes().contains(edge.getTargetNode())){
                        return true;
                    }
                    if (!nextNodes.contains(edge.getTargetNode()) && !investigatedNodes.contains(edge.getTargetNode())){
                        nextNodes.add(edge.getTargetNode());
                    }
                }
            }
            investigatedNodes.addAll(currentNodes);
            currentNodes.clear();
            currentNodes.addAll(nextNodes);
        }

        return false;
    }
}
