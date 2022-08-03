import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class tank{
    int x;
    int y;
    int d;
     
    public tank() {};
     
    public tank(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
 
public class Main {
    static char[][] map;
    static int[] dx = { 0, 0,-1, 1}; //상하좌우 인덱스 접근 0,1,2,3 
    static int[] dy = {-1, 1, 0, 0};
    static char[] dir = {'^','v','<','>'};
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = Integer.parseInt(br.readLine());
        for (int T = 1; T < t+1; T++) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            map = new char[n][m];
             
            tank tank = new tank();
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == '^') {
                        tank = new tank(j, i, 0); 
                    }
                    else if (map[i][j] == 'v') {
                        tank = new tank(j, i, 1);                       
                    }
                    else if (map[i][j] == '<') {
                        tank = new tank(j, i, 2);
                    }
                    else if (map[i][j] == '>') {
                        tank = new tank(j, i, 3);
                    }
                }
            }
             
            int l = Integer.parseInt(br.readLine());
            char[] cmds = br.readLine().toCharArray();
             
            for (char cmd : cmds) {
                switch (cmd) {
                case 'U':
                    turn(tank, 0);
                    go(tank);
                    break;
                case 'D':
                    turn(tank, 1);
                    go(tank);
                    break;
                case 'L':
                    turn(tank, 2);
                    go(tank);
                    break;
                case 'R':
                    turn(tank, 3);
                    go(tank);
                    break;
                case 'S':
                    shoot(tank);
                    break;
 
                default:
                    break;
                }
            }
             
             
             
            // 출력
            System.out.printf("#%d ", T);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
             
             
        }
         
         
    }
    public static void go(tank tank) {
        int nx = tank.x + dx[tank.d];
        int ny = tank.y + dy[tank.d];
         
        if (nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length ) {
            if (map[ny][nx] == '.') {
                map[tank.y][tank.x] = '.';
                tank.x = nx;
                tank.y = ny;
                map[tank.y][tank.x] = dir[tank.d];
            }
        }
    }
    public static void shoot(tank tank) {
        int start_x = tank.x;
        int start_y = tank.y;
        int mul = 1;
        while(true) {
            int nx = start_x+dx[tank.d]*mul;
            int ny = start_y+dy[tank.d]*mul;
            if (nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length ) {
                if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                    break;
                }
                else if (map[ny][nx] == '#') {
                    break;
                }
                 
            }
            else {
                break;
            }
            mul++;
        }
    }
    public static void turn(tank tank, int n) {
        tank.d = n;
        map[tank.y][tank.x] = dir[tank.d];
    }
}