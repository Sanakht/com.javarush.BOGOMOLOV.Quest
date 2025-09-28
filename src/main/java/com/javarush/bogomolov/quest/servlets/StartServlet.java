package com.javarush.bogomolov.quest.servlets;

import com.javarush.bogomolov.quest.constants.AppConstants;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "start-Servlet", value = "/start")
public class StartServlet extends HttpServlet {

    private static String question;
    private static String answer;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();


        if(session.getAttribute(AppConstants.SessionParameters.START) == null) {
            session.setAttribute(AppConstants.SessionParameters.START, true);
            session.setAttribute(AppConstants.SessionParameters.WEAPON, false);
            session.setAttribute(AppConstants.SessionParameters.DEAD, false);
            session.setAttribute(AppConstants.SessionParameters.WIN, false);
            session.setAttribute(AppConstants.SessionParameters.QUESTION, null);
//            session.setAttribute(AppConstants.SessionParameters.ANSWER, answer);
        }


        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        answer = (String) request.getParameter("answer");

        if(answer != null) {
            switch(answer) {
                case "ANSWER_1_1" -> {
                    question = AppConstants.Question.QUESTION_2;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                }
                case "ANSWER_1_2" -> {
                    question = AppConstants.Question.QUESTION_SLEEP_END;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.DEAD, true);
                }
                case "ANSWER_1_3" -> {
                    question = AppConstants.Question.QUESTION_3;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                }
                case "ANSWER_2_1" -> {
                    question = AppConstants.Question.QUESTION_WAIT_WIN;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.WIN, true);
                }
                case "ANSWER_2_2" -> {
                    question = AppConstants.Question.QUESTION_4;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.WEAPON, true);
                }
                case "ANSWER_2_3" -> {
                    question = AppConstants.Question.QUESTION_3;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                }
                case "ANSWER_3_1" ->{
                    question = AppConstants.Question.QUESTION_RUN_IN_HOUSE_END;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.DEAD, true);
                }
                case "ANSWER_3_2" ->{
                    question = AppConstants.Question.QUESTION_CLOSE_DOOR_END;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.DEAD, true);
                }
                case "ANSWER_3_3" ->{
                    question = AppConstants.Question.QUESTION_RUN_OUT_HOUSE_WIN;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.WIN, true);
                }
                case "ANSWER_4_1" ->{
                    question = AppConstants.Question.QUESTION_CLOSE_DOOR_WITH_WEAPON_END;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.DEAD, true);
                }
                case "ANSWER_4_2" ->{
                    question = AppConstants.Question.QUESTION_ATTACK_WIN;
                    session.setAttribute(AppConstants.SessionParameters.QUESTION, question);
                    session.setAttribute(AppConstants.SessionParameters.WIN, true);
                }
            }
        }
        response.sendRedirect("index.jsp");








    }


}