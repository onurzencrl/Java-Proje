package kodlamaio.hrms.core.business;

import kodlamaio.hrms.core.results.Result;

public class BusinessRules {

    public static Result run(Result... logics) {
        for (Result logic : logics) {
            if (logic != null && !logic.isSuccess()) {
                return logic;
            }
        }
        return null;
    }
}
