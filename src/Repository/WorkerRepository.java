package Repository;

import Model.SalaryHistory;
import Model.Worker;
import java.util.ArrayList;
import java.util.Collections;

import DataAccess.WorkerDao;

public class WorkerRepository implements IWorkerRepository {
    public WorkerRepository() {
    }

    @Override
    public void addWorker(ArrayList<Worker> workers) {
        WorkerDao.Instance().addWorker(workers);
    }

    @Override
    public void changeSalary(ArrayList<Worker> workers,ArrayList<SalaryHistory> salaryHistories,int type){
        WorkerDao.Instance().changeSalary(workers, salaryHistories, type);
    }

    @Override
    public void getInformationSalary(ArrayList<SalaryHistory> salaryHistories) {
        if (salaryHistories.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");
        Collections.sort(salaryHistories);
        // print history from first to last list
        for (SalaryHistory history : salaryHistories) {
            System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", history.getCode(), history.getName(), history.getAge(),
                    history.getSalary(), history.getStatus(), history.getDate());
        }
    }
}
