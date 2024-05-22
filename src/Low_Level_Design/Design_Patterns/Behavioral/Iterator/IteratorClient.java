package Low_Level_Design.Design_Patterns.Behavioral.Iterator;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

//organization hierarchy using two different iterators: one for a depth-first search (DFS) and another for a breadth-first search (BFS).

//Employee Class

class Employee {
    private String name;
    private String position;
    private List<Employee> subordinates;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', position='" + position + "'}";
    }
}


//Iterator Interface

interface Iterator<T> {
    boolean hasNext();
    T next();
}


//Concrete Iterators

class DepthFirstIterator implements Iterator<Employee> {
    private Stack<Employee> stack;

    public DepthFirstIterator(Employee root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Employee next() {
        if (hasNext()) {
            Employee current = stack.pop();
            List<Employee> subordinates = current.getSubordinates();
            for (int i = subordinates.size() - 1; i >= 0; i--) {
                stack.push(subordinates.get(i));
            }
            return current;
        }
        return null;
    }
}


class BreadthFirstIterator implements Iterator<Employee> {
    private Queue<Employee> queue;

    public BreadthFirstIterator(Employee root) {
        queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Employee next() {
        if (hasNext()) {
            Employee current = queue.poll();
            queue.addAll(current.getSubordinates());
            return current;
        }
        return null;
    }
}

//Iterable Collection Interface

interface IterableCollection<T> {
    Iterator<T> createDepthFirstIterator();
    Iterator<T> createBreadthFirstIterator();
}

//Concrete Collection Interface

class Organization implements IterableCollection<Employee> {
    private Employee root;

    public Organization(Employee root) {
        this.root = root;
    }

    @Override
    public Iterator<Employee> createDepthFirstIterator() {
        return new DepthFirstIterator(root);
    }

    @Override
    public Iterator<Employee> createBreadthFirstIterator() {
        return new BreadthFirstIterator(root);
    }
}


public class IteratorClient {
    public static void main(String[] args) {
        // Creating the organizational hierarchy


        Employee ceo = new Employee("Alice", "CEO");
        Employee vpEngineering = new Employee("Bob", "VP of Engineering");
        Employee vpMarketing = new Employee("Charlie", "VP of Marketing");
        Employee engineer1 = new Employee("Dave", "Engineer");
        Employee engineer2 = new Employee("Eve", "Engineer");
        Employee marketer1 = new Employee("Frank", "Marketer");

        ceo.addSubordinate(vpEngineering);
        ceo.addSubordinate(vpMarketing);
        vpEngineering.addSubordinate(engineer1);
        vpEngineering.addSubordinate(engineer2);
        vpMarketing.addSubordinate(marketer1);

        Organization organization = new Organization(ceo);

        System.out.println("Depth-First Traversal:");
        Iterator<Employee> depthFirstIterator = organization.createDepthFirstIterator();
        while (depthFirstIterator.hasNext()) {
            Employee employee = depthFirstIterator.next();
            System.out.println(employee);
        }

        System.out.println("\nBreadth-First Traversal:");
        Iterator<Employee> breadthFirstIterator = organization.createBreadthFirstIterator();
        while (breadthFirstIterator.hasNext()) {
            Employee employee = breadthFirstIterator.next();
            System.out.println(employee);
        }
    }


}
