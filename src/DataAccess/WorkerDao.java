package DataAccess;

import java.util.ArrayList;

import Common.Validation;
import Model.SalaryHistory;
import Model.Worker;

public class WorkerDao {
    private static WorkerDao instance = null;

    public static WorkerDao Instance(){
        if(instance == null){
            synchronized (WorkerDao.class){
                if(instance == null){
                    instance = new WorkerDao();
                }
            }
        }
        return instance;
    }

    public void addWorker(ArrayList<Worker> workers){
        while(true){
            String code = Validation.getString("Enter Code:");
            for (Worker w : workers){
                if(w.getCode().equalsIgnoreCase(code)){
                    System.out.println("Dupplicate!!!");
                    return;
                }
            }
            String name = Validation.getString("Enter Name: ");
            int age = Validation.getInt("Enter Age:", 18, 50);
            int salary = Validation.getInt("Enter Salary: ",0,999999999);
            String workLocation = Validation.getString("Enter work location: ");
            workers.add(new Worker(code, name, age, salary, workLocation));
            if(Validation.getYesNo("Do you want to continue(Y/N): ").equalsIgnoreCase("N")){
                return;
            }
        }
    }

    public void changeSalary(ArrayList<Worker> workers,ArrayList<SalaryHistory> salaryHistories,int type){
        if(workers.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        String code = Validation.getString("Enter Code: ");
        Worker w = getWorkerByCode(workers, code);
        if(w == null){
            System.out.println("");
            return;
        }else {
            int currentSalary = w.getSalary();
            int updateSalary;
            if(type == 1){
                updateSalary = Validation.getInt("Enter Update Salary: ", currentSalary, 999999999);
                salaryHistories.add(new SalaryHistory(w.getCode(), w.getName(), w.getAge(), updateSalary, w.getWorkLocation(), "UP", Validation.getCurrentDate()));
            }else{
                updateSalary = Validation.getInt("Enter Update Salary: ", 0, currentSalary);
                salaryHistories.add(new SalaryHistory(w.getCode(), w.getName(), w.getAge(), updateSalary, w.getWorkLocation(), "DOWN", Validation.getCurrentDate()));
            }
            w.setSalary(updateSalary);
            System.out.println("Update success");
        }
    }

    public Worker getWorkerByCode(ArrayList<Worker> workers,String code) {
        for (Worker w : workers) {
            if (w.getCode().equalsIgnoreCase(code)) {
                return w;
            }
        }
        return null;
    }
}
