package org.example;

import com.svalero.padel.dao.ClubPadelDao;
import com.svalero.padel.dao.Database;
import com.svalero.padel.dao.JugadorDao;
import com.svalero.padel.domain.ClubPadel;
import com.svalero.padel.domain.Jugador;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        try{
            System.out.println("Hello world!");
            Database database = new Database();
           /* ClubPadelDao clubPadelDao = new ClubPadelDao(database.getConnection());
            List<ClubPadel> listClubsPadel = clubPadelDao.showAll();
            System.out.println(listClubsPadel.size());
            System.out.println(clubPadelDao.findByName("prueba").isEmpty());*/
            JugadorDao jd = new JugadorDao((database.getConnection()));
            Jugador j = new Jugador("03", "Mar", "m", "-80",45, "reves");
            jd.add(j);
        } catch (SQLException sqle) {
            System.out.println("Error modificando registro");
            sqle.printStackTrace();
        }
    }
}