package Repository;

import java.util.ArrayList;

import Model.SalaryHistory;
import Model.Worker;

public interface IWorkerRepository {
    void addWorker(ArrayList<Worker> workers);
    void changeSalary(ArrayList<Worker> workers,ArrayList<SalaryHistory> salaryHistories,int type);
    void getInformationSalary(ArrayList<SalaryHistory> salaryHistories);
}
