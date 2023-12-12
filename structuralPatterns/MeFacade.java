package myTest.structuralPatterns;

public class MeFacade {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade(new CPU(), new Memory(), new HardDrive());
        computerFacade.start();

        System.out.println();

        computerFacade.shutdown();
    }
}

// 시스템 인터페이스
interface Systems {
    void start();
    void shutdown();
}

// 시스템 1
class CPU implements Systems {
    @Override
    public void start() {
        System.out.println("CPU 시작");
    }

    @Override
    public void shutdown() {
        System.out.println("CPU 종료");
    }
}

// 시스템 2
class Memory implements Systems {
    @Override
    public void start() {
        System.out.println("메모리 로딩");
    }

    @Override
    public void shutdown() {
        System.out.println("메모리 해제");
    }
}

// 시스템 3
class HardDrive implements Systems {
    @Override
    public void start() {
        System.out.println("하드 드라이브 읽기");
    }

    @Override
    public void shutdown() {
        System.out.println("하드 드라이브 쓰기");
    }
}

// 퍼사드
class ComputerFacade {
    private Systems cpu;
    private Systems memory;
    private Systems hardDrive;

    public ComputerFacade(Systems cpu, Systems memory, Systems hardDrive) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public void start() {
        cpu.start();
        memory.start();
        hardDrive.start();
        System.out.println("컴퓨터 시작");
    }

    public void shutdown() {
        cpu.shutdown();
        memory.shutdown();
        hardDrive.shutdown();
        System.out.println("컴퓨터 종료");
    }


}
