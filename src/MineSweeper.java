public class MineSweeper {
    public static void main(String[] args) {
        MineSweeper application = new MineSweeper();

        application.run();
    }

    private void run() {
        //준비
        MapMaker mapMaker = new MapMaker(10, 15);
        mapMaker.makeMap();

        //HintMaker
        //ResultChecker
    }
}
