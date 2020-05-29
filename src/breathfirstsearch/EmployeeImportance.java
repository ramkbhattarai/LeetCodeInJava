package breathfirstsearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeImportance {
	Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }
    
    // 2nd approach
    public int getImportance2(List<Employee> employees, int id) {
        int result = 0, size = employees.size(), i=0;
        Set<Integer> set = new HashSet();
        set.add(id);
        
        while(!set.isEmpty()){
            Employee emp = employees.get(i);
            
            if(set.contains(emp.id)){
                result += emp.importance;
                
                for(int emp_id: emp.subordinates)
                    set.add(emp_id);
                
                set.remove(emp.id);
            }
            
            if(i==size-1)
                i=0;
            else
                i++;
        }
        
        return result;
    }
    
    
    public int getImportance3(List<Employee> employees, int id) {
        // store employees in a id-employee map for easy referencing
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) 
            map.put(emp.id, emp);
        
        return helper(map, id);
    }
    
    // recursively sum up importance value of all subordinates
    private int helper(Map<Integer, Employee> emps, int id) {
        Employee emp = emps.get(id);
        int total = emp.importance;
        for (Integer subId : emp.subordinates) {
            total += helper(emps, subId);
        }
        return total;
    }

}
