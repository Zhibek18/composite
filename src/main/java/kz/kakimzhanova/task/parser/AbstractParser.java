package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.Composite;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import kz.kakimzhanova.task.exception.MethodNotSupportedException;
import kz.kakimzhanova.task.exception.NullStringArrayException;
import kz.kakimzhanova.task.exception.NullSuccessorException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractParser {
    private Logger logger = LogManager.getLogger();
    private AbstractParser successor = DefaultParser.getDefaultParser();
    private ComponentType type;
    public AbstractParser(AbstractParser successor, ComponentType type) {
        try {
            if (successor != null) {
                this.successor = successor;
                this.type = type;
            } else {
                throw new NullSuccessorException("Expected Abstract task successor");
            }
        }catch (NullSuccessorException e){
            logger.log(Level.WARN, e);
        }
    }
    public AbstractParser (){}
    public Component chain (String s) throws NullStringArrayException{
        Component component = new Composite(type);
        String[] parsedStrings = parse(s);
        if (parsedStrings != null){
            try{
                for (String string : parsedStrings) {
                    component.add(successor.chain(string));
                }
            }catch (MethodNotSupportedException e) {
                logger.log(Level.WARN, e);
            }
        } else{
            throw new NullStringArrayException("Got null strings array from parse");
        }
        return component;
    }
    public abstract String[] parse (String s);
    private static class DefaultParser extends AbstractParser{
        private static DefaultParser defaultParser = new DefaultParser();
        private DefaultParser() {}

        static DefaultParser getDefaultParser(){
            return defaultParser;
        }

        public String[] parse(String s){
            return new String[0];
        }
    }
}
