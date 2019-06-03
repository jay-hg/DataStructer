package bfscfs;

import java.util.*;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        //构建emp的map
        Map<Integer, Employee> map = new HashMap<>(employees.size());
        employees.forEach(employee -> {
            map.put(employee.id,employee);
        });

//        辅助队列
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(id);
        int ans = 0;

        while (!queue.isEmpty()) {
            Integer eid = queue.poll();
            Employee employee = map.get(eid);
            ans += employee.importance;
            for (Integer i : employee.subordinates) {
                queue.offer(i);
            }
        }

        return ans;
    }
}

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
