package org.suprun.filesearch.model.predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class AppliancePredicate {

    public BiPredicate<String, String> predicate = (String f, String par) -> f.contains(par);
}
