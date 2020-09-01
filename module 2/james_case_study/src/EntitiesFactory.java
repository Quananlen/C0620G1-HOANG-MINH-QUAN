public class EntitiesFactory {
    public IEntities createEntities(String type, String word) {
        switch (type) {
            case "--noun":
            case "-n":
                return new Noun(word);
            case "--adj":
            case "-a":
                return new Adj(word);
            case "--verb":
            case "-v":
                return new Verb(word);
            default:
                return new Synonyms(word);
        }
    }
}
