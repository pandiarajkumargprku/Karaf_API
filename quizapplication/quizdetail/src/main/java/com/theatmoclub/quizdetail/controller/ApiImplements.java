package com.theatmoclub.quizdetail.controller;

import com.theatmoclub.quizdetail.model.Quiz;
import org.osgi.service.component.annotations.Component;

import javax.ws.rs.*;
import java.util.List;

@Component(service = Api.class)
public class ApiImplements implements Api {

    private static final CrudController CRUD_CONTROLLER = new CrudController();

    /**
     * get first round details
     *
     */
    @Path("/firstLevel")
    @Produces("application/json")
    @GET
    public List<Quiz> getFirstRoundDetails(@QueryParam("page") int page, @QueryParam("limit") int limit) {
        List<Quiz> list=CRUD_CONTROLLER.getFirstRoundDetails();

        int start = 0;
        int end =0;

        if(page > 0 && limit >= 0 ) {
            start = (page - 1) * limit ;
            end = page * limit;
        } if(start < list.size() && end <list.size()) {
            return list.subList(start, end);
        } if(start < list.size()) {
            return list.subList(start ,list.size());
        }
        return null;
    }

    /**
     * get second round details
     *
     */
    @Path("/secondLevel")
    @Produces("application/json")
    @GET
    public List<Quiz> getSecondRoundDetails() {
        return CRUD_CONTROLLER.getSecondRoundDetails();
    }

    /**
     * get third round details
     *
     */
    @Path("/thirdLevel")
    @Produces("application/json")
    @GET
    public List<Quiz> getThirdRoundDetails() {
        return CRUD_CONTROLLER.getThirdRoundDetails();
    }

    /**
     * delete the question
     *
     * @param questionNumber
     * @param roundNumber
     * @return
     */
    @Path("/delete/{questionNumber}/{roundNumber}")
    @Consumes("application/json")
    @DELETE
    public boolean questionDelete(@PathParam("questionNumber") final int questionNumber, @PathParam("roundNumber") final int roundNumber) {
        return CRUD_CONTROLLER.questionDelete(questionNumber, roundNumber);
    }

    /**
     * insert the question
     *
     * @param quizTools
     * @param roundNumber
     * @return
     */
    @Path("/insert/{roundNumber}")
    @Produces("application/json")
    @POST
    public boolean questionInsert(final Quiz quizTools, @PathParam("roundNumber") final int roundNumber) {
        return CRUD_CONTROLLER.questionInsert(quizTools, roundNumber);
    }

    /**
     * update the question
     *
     * @param quizTools
     * @param roundNumber
     * @return
     */
    @Path("/update/{roundNumber}")
    @Consumes("application/json")
    @PUT
    public boolean questionUpdate(final Quiz quizTools, @PathParam("roundNumber") final int roundNumber) {
        return CRUD_CONTROLLER.questionUpdate(quizTools, roundNumber);
    }
}


