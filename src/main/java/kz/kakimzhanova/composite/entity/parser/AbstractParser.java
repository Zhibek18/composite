package kz.kakimzhanova.composite.entity.parser;

import kz.kakimzhanova.composite.entity.Component;
import kz.kakimzhanova.composite.entity.Composite;
import kz.kakimzhanova.composite.entity.CompositeType;
import kz.kakimzhanova.composite.exception.AddNotSupportedException;
import kz.kakimzhanova.composite.exception.NullSuccessorException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AbstractParser {
    private Logger logger = LogManager.getLogger();
    private AbstractParser successor = DefaultParser.getDefaultParser();
    private CompositeType type = CompositeType.LEXEME;
    public AbstractParser(AbstractParser successor, CompositeType type) {
        try {
            if (successor != null) {
                this.successor = successor;
                this.type = type;
            } else {
                throw new NullSuccessorException("Got null pointer argument, expected Abstract composite successor");
            }
        }catch (NullSuccessorException e){
            logger.log(Level.WARN, e);
        }
    }
    public AbstractParser (){

    }
    public Component chain (String s){
        Component component = new Composite(type);
        String[] strings = parse(s);
        if (strings == null){
            logger.log(Level.WARN, "null strings array from parse");
        }
        try{
            Component tmp;
            for (String str : strings) {
                tmp = successor.chain(str);
                component.add(tmp);
            }
        }catch (AddNotSupportedException e){
            logger.log(Level.WARN, e);
        }
        return component;
    }
    public abstract String[] parse (String s);
    private static class DefaultParser extends AbstractParser{
        private static DefaultParser defaultParser = new DefaultParser();
        private DefaultParser() {}

        public static DefaultParser getDefaultParser(){
            return defaultParser;
        }

        public String[] parse(String s){
            return new String[0];
        }
    }

}
