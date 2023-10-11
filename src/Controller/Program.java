package Controller;

import java.util.ArrayList;

import Model.SalaryHistory;
import Model.Worker;
import Repository.IWorkerRepository;
import Repository.WorkerRepository;
import View.Menu;

public class Program extends Menu<String> {
    private IWorkerRepository workerRepository;
    static String[] menuChoice = { "Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit" };
    ArrayList<Worker> worker = new ArrayList<>();
    ArrayList<SalaryHistory> salaryHistories = new ArrayList<>();

    public Program() {
        super("========== Worker Management ==========", menuChoice);
        workerRepository = new WorkerRepository();
    }

    public void execute(int n) {
        switch (n) {
            case 1:
                workerRepository.addWorker(worker);
                break;
            case 2:
                workerRepository.changeSalary(worker, salaryHistories, 1);
                break;
            case 3:
                workerRepository.changeSalary(worker, salaryHistories, 2);
                break;
            case 4:
                workerRepository.getInformationSalary(salaryHistories);
                break;
            case 5:
                System.exit(0);
        }
    }
}
