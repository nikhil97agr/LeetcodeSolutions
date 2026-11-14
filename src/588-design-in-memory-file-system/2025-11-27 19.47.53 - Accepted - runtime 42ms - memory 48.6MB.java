import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FileSystem {
    FileSystemNode root;
    public FileSystem() {
        root = new Directory("");
    }
    
    public List<String> ls(String path) {
        FileSystemNode root = this.root;

        String paths[] = path.split("/");

        for(int i=1;i<paths.length;i++){
            root = root.getChildren(paths[i]);
        }

        return root.ls();
    }
    
    public void mkdir(String path) {
        String paths[] = path.split("/");
        FileSystemNode root = this.root;
        for(int i=1;i<paths.length;i++){
            FileSystemNode next = root.getChildren(paths[i]);
            if(next == null){
                next = new Directory(paths[i]);
                root.addToPath(next);
            }
            root = next;
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        FileSystemNode root = this.root;
        String paths[] = filePath.split("/");

        for(int i=1;i<paths.length-1;i++){
            FileSystemNode node = root.getChildren(paths[i]);
            if(node == null){
                node = new Directory(paths[i]);
                root.addToPath(node);
            }

            root = node;
        }
        int n = paths.length;
        FileSystemNode file = root.getChildren(paths[n-1]);

        if(file == null){
            file = new File(paths[n-1], content);
            root.addToPath(file);
        }else{
            file.addContent(content);
        }
    }
    
    public String readContentFromFile(String filePath) {
        FileSystemNode root = this.root;

        String paths[] = filePath.split("/");

        for(int i=1;i<paths.length;i++){
            root = root.getChildren(paths[i]);
        }

        return root.getContent();
    }
}

abstract class FileSystemNode{
    private String name;
    public abstract boolean isFile();
    protected FileSystemNode(String name){
        this.name = name;
    }

    public abstract void addContent(String content);
    public abstract void addToPath(FileSystemNode node);
    public abstract String getContent();
    public String getName(){
        return this.name;
    }
    public abstract FileSystemNode getChildren(String name);
    public abstract List<String> ls();
}

class File extends FileSystemNode{
    private StringBuilder content;
    protected File(String name, String content) {

        super(name);
        this.content =new StringBuilder(content);

    }

    @Override
    public boolean isFile() {

        return true;
    }

    @Override
    public void addContent(String content) {
        this.content.append(content);
    }

    @Override
    public void addToPath(FileSystemNode node) {

    }

    @Override
    public String getContent() {

        return content.toString();
    }

    @Override
    public FileSystemNode getChildren(String name) {

        return null;
    }

    @Override
    public List<String> ls() {

        return List.of(getName());
    }
}

class Directory extends FileSystemNode{
    Map<String, FileSystemNode> children;
    protected Directory(String name) {

        super(name);
        children  =new HashMap<>();
    }

    @Override
    public boolean isFile() {

        return false;
    }

    @Override
    public void addContent(String content) {

    }

    @Override
    public void addToPath(FileSystemNode node) {
        children.put(node.getName(), node);
    }

    @Override
    public String getContent() {

        return "";
    }

    @Override
    public FileSystemNode getChildren(String name) {

        return children.get(name);
    }

    @Override
    public List<String> ls() {

        return children.values().stream().map(FileSystemNode::getName).sorted().collect(Collectors.toList());
    }
}
