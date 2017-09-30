import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.ListIterator;


public class Scene extends JPanel implements ActionListener {

    private final int shipStartx = 280;
    private final int shipStarty = 500;
    private final int DELAY = 50;
    private Timer timer;
    private Player ship;

    private MapController map;
    private EnemyController enemys;
    private ExplosionController explosions;
    private EnemyBulletController enemyBullets;
    Events events;

    int playCounter = 0;

    int background11 = 0;
    int background21 = -1000;

    int background22 = 0;
    int background12 = -1000;

    int gameState = 3;
    int delay = 0;

    int menuY = 10;
    int score = 0;



    public Scene() {

        initScene();
    }

    private void initScene() {

        ship = new Player(shipStartx, shipStarty, 0,1);

        events = new Events();
        events.addObserver(ship);
        addKeyListener(new EventAdaptor(events));




        setFocusable(true);

        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(new SceneAdapter());



        map = new MapController();
        enemys = new EnemyController(30);
        explosions = new ExplosionController();
        enemyBullets = new EnemyBulletController();

        timer = new Timer(DELAY, this);
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //System.out.print("paint");

        Graphics2D g2d = (Graphics2D) g;
        drawBackground(g2d);


        drawEnemy(g2d);

        drawEnemyBullets(g2d);





        if(gameState == 1) {
            //drawMap(g2d);
            //drawMap(g2d);

            drawProjectiles(g);
            drawPlayer1(g);
            drawStatusBar(g);



        }
        drawExplosions(g2d);

        if(this.gameState ==3){
            drawSplash(g);

        }
        if(gameState == 1) {
            //drawMap(g2d);
            drawStatusBar(g);
        }






        Toolkit.getDefaultToolkit().sync();
    }
    public void drawSplash(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        ImageIcon ii = new ImageIcon("Resources/splash.png");
        Image image;
        image = ii.getImage();

        g2d.drawImage(image, 150,
                menuY, this);

        Font font = g.getFont();//Font font = new Font(14);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));

        //g.setFont(font);


        g.drawString("Game Over!", 50 , menuY + 650);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        //g.setFont(font);


        g.drawString("Press 1 To Play", 220 , menuY + 350);

    }


    public void drawStatusBar(Graphics g) {

        g.setColor(Color.BLACK);
        //g.fillRect(0, 0, ship.getHealth(), 15);
        g.fillRect(0, 530, 600, 70);

        g.setColor(Color.RED);
        //g.fillRect(0, 0, ship.getHealth(), 15);
        g.fillRect(0, 530, 600, 3);

        g.setColor(Color.GREEN);
        g.fillRect(500, 540, ship.getHealth(), 30);

        Font font = g.getFont();//Font font = new Font(14);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Cambria", Font.PLAIN, 26));


        g.drawString("Health:", 400, 563);


        g.setColor(Color.WHITE);
        g.setFont(new Font("Cambria", Font.PLAIN, 26));


        g.drawString("Score: " + score, 100, 563);

        //g.setColor(Color.GREEN);
       // g.setFont(new Font("Cambria", Font.PLAIN, 70));
    }

    public void drawState0Message(Graphics g) {

        Font font = g.getFont();//Font font = new Font(14);

        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 100));

        //g.setFont(font);


        g.drawString("Game Over!", 230, 300);


    }

/*
    public void drawState3Message(Graphics g) {

        Font font = g.getFont();//Font font = new Font(14);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Cambria", Font.PLAIN, 30));

        //g.setFont(font);


        g.drawString("Player 1 W-S-A-D to move Q to shoot", ship.getX() + 70, ship.getY()+40);
        g.drawString("Player 2 Arrow keys to move SPACE to shoot", ship2.getX() - 650, ship2.getY()+30);

        g.setColor(Color.GREEN);
        g.setFont(new Font("Cambria", Font.PLAIN, 70));

        g.drawString("To Select map and play: ", 60, ship.getY()+300);
        g.drawString("press any number 1-5 ", 80, ship.getY()+400);





    }
    */



    public void drawMap(Graphics2D g2) {


        ListIterator<MapUnit> units = map.getMap();

        while(units.hasNext()){
            MapUnit unit = units.next();
            g2.drawImage(unit.getImage(), unit.getX(),
                    unit.getY(), this);

        }
    }
    public void drawEnemy(Graphics2D g2) {


        ListIterator<EnemyUnit> units = enemys.getEnemy();

        while(units.hasNext()){

            EnemyUnit unit = units.next();
            g2.drawImage(unit.getImage(), unit.getX()-23,
                    unit.getY(), this);
           // System.out.print(unit.getWidth());

        }
    }


    public void drawEnemyBullets(Graphics2D g2) {


        ListIterator<Bullet> units = enemyBullets.getBullet();

        while(units.hasNext()){

            Bullet unit = units.next();
            g2.drawImage(unit.getImage(), unit.getX()+3,
                    unit.getY(), this);


        }
    }
    public void drawExplosions(Graphics2D g2) {


        ListIterator<Explosion> units = explosions.getExplosions();

        while(units.hasNext()){
            Explosion unit = units.next();

            g2.drawImage(unit.getImage(), (unit.getX()-(unit.getHeight()/2)),
                    (unit.getY()-(unit.getWidth()/2)), this);
           // System.out.print(unit.getWidth());

        }
    }


    public void drawBackground(Graphics2D g2)
    {
        int h = this.getHeight();
        int w = this.getWidth();



        Image image;
        ImageIcon ii = new ImageIcon("Resources/star.png");
        image = ii.getImage();


        int width = image.getWidth(null);
        int height = image.getHeight(null);

        g2.drawImage(image, 0 , background11
                , width,
                height, this);
        g2.drawImage(image, 0 , background21
                , width,
                height, this);

        Image image2;
        ImageIcon ii2 = new ImageIcon("Resources/starparallax.png");
        image2 = ii2.getImage();

        g2.drawImage(image2, 0 , background22
                , width,
                height, this);
        g2.drawImage(image2, 0 , background12
                , width,
                height, this);

    }

    private void drawProjectiles(Graphics g) {

        Graphics2D g2d2 = (Graphics2D) g;


        ArrayList ms = ship.getBullets();

        for (Object m1 : ms) {
            Bullet b = (Bullet) m1;
            g2d2.drawImage(b.getImage(), b.getX(),
                    b.getY(), this);

        }

    }


    private void drawPlayer1(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(ship.getImage(), ship.getX()-23,
                ship.getY()-20, this);


    }





    @Override
    public void actionPerformed(ActionEvent e) {



        if(gameState == 1) {
            enemys.genEnemy1(5);
            if(playCounter >3000){
                enemys.genEnemy1(2);

            }
            if(playCounter >3000){
                //enemys.genEnemy2(5);

            }


        }if(gameState == 0 ){
            ship.reset();
            gameState =1;

        }
        if(gameState == 3){
            updateMenu();
            playCounter+=1;

        }

        updateMissiles();

        updateExplosions();
        updateships();

        updateEnemyBullets();
        moveEnemyBullets();



        updateBackground();



        repaint();
        //System.out.print("collision");
    }
    public void updateMenu(){
        if(menuY < 10){
            menuY = menuY +5;
        }
    }
    public void updateEnemyBullets() {


        ListIterator<EnemyUnit> units = enemys.getEnemy();

        while(units.hasNext()){

            EnemyUnit unit = units.next();
           if(unit.shoot(enemys.getCount()) == 1){
               Bullet b = new Bullet(unit.getX() - 5, unit.getY() , 15);
               enemyBullets.addUnit(b);
           }

        }
    }
    public void moveEnemyBullets() {


        ListIterator<Bullet> units = enemyBullets.getBullet();

        while(units.hasNext()){

            Bullet unit = units.next();
            unit.move();


        }
    }
    private void updateExplosions(){
        ListIterator<Explosion> units = explosions.getExplosions();
        int state = 0;
        Explosion unit = null;
        while(units.hasNext()){
            unit = units.next();
            state = unit.cycle();
            //System.out.print("update Explosions");




        }
        if(state == 2){
            explosions.remove(unit);
        }
    }
    private void updateBackground(){
        background11 ++;
        background21++;
        if(background11 == 0){
            background21 = -1000;
        }
        if(background21 == 0){
            background11 = -1000;
        }


        background22 +=5;
        background12+=5;
        if(background22 == 0){
            background12 = -1000;
        }
        if(background12 == 0){
            background22 = -1000;
        }
    }

    private void updateMissiles() {

        Rectangle pbox2 = new Rectangle(ship.getX()-25, ship.getY(), ship.getWidth(), ship.getHeight());

        ArrayList ms = ship.getBullets();



        for (int i = 0; i < ms.size(); i++) {

            Bullet m = (Bullet) ms.get(i);

            if (m.isVisible()) {

                m.move();
            } else {

                ms.remove(i);
            }
            Rectangle mbox = new Rectangle(m.getX(), m.getY(), m.getWidth(), m.getHeight());

            ListIterator<EnemyUnit> units = enemys.getEnemy();
            while (units.hasNext()) {
                EnemyUnit unit = units.next();
                Rectangle enemyBox = new Rectangle(unit.getX()-23, unit.getY(), unit.getWidth(), unit.getHeight());

                if (mbox.intersects(enemyBox)) {
                    Explosion Eunit = new Explosion(m.getX(), m.getY());
                    explosions.addUnit(Eunit);
                    m.setNotVisible();
                    units.remove();
                    score+=200;

                }


            }
        }




    }

    private void updateships() {

        enemys.moveEnemys();

        ship.move();

        if (ship.getHealth() <= 0) {

            ship.arbitraryMove();
            if (delay > 40) {

                gameState = 3;
                ship.setVisible(false);
                playCounter = 0;


            }


            delay = delay + 1;

        }




        /*
          ListIterator<MapUnit> units = map.getMap();

        while(units.hasNext()){
            MapUnit unit = units.next();
            Rectangle mbox = new Rectangle(unit.getX(), unit.getY(), unit.getWidth(), unit.getHeight());

            if(pbox.intersects(mbox)) {
                //System.out.print("collision");
                if (ship.getY() < unit.getY())
                    ship.shunt(0, -3);
                if (ship.getY() > unit.getY())
                    ship.shunt(0, 3);
                if (ship.getX() < unit.getX())
                    ship.shunt(-3, 0);
                if (ship.getX() > unit.getX())
                    ship.shunt(3, 0);
            }




        }
        */

        Rectangle pbox = new Rectangle(ship.getX()-27, ship.getY(), ship.getWidth(), ship.getHeight());

        ListIterator<EnemyUnit> units = enemys.getEnemy();
        while (units.hasNext()) {
            EnemyUnit unit = units.next();
            Rectangle enemyBox = new Rectangle(unit.getX()-20, unit.getY(), unit.getWidth(), unit.getHeight());

            if (pbox.intersects(enemyBox)) {
                Explosion Eunit = new Explosion((int)((enemyBox.getX()+pbox.getX())/2)+25, (int)enemyBox.getY()+ship.getHeight()/2);
                explosions.addUnit(Eunit);
                events.setValue(3);
                units.remove();
                score-=33;

            }


        }
        ListIterator<Bullet> units2 = enemyBullets.getBullet();
        while (units2.hasNext()) {
            Bullet unit = units2.next();
            Rectangle bulletBox = new Rectangle(unit.getX(), unit.getY(), unit.getWidth(), unit.getHeight());

            if (pbox.intersects(bulletBox)) {
                Explosion Eunit = new Explosion((int)bulletBox.getX(), (int)bulletBox.getY());
                explosions.addUnit(Eunit);
                events.setValue(3);
                units2.remove();
                score-=33;

            }


        }







    }
    private class SceneAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();

                if (key == KeyEvent.VK_1) {
                    gameState = 0;
                    menuY = -800;
                    int score = 0;
                }

        }


    }



}