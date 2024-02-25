package raf.ds.gerumap.gui.swing.controller;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private InfoAction infoAction;
    private EditAction editAction;
    private DeleteAction deleteAction;
    private SetAuthorAction setAuthorAction;
    private DrawRectangle drawRectangle;
    private ElementDelete elementDelete;
    private ElementSelect elementSelect;
    private ElementMove elementMove;
    private DrawLine drawLine;
    private ChooseColor chooseColor;
    private ChooseLineStroke chooseLineStroke;
    private AddText addText;
    private ElementZoom elementZoom;
    private RedoAction redoAction;
    private UndoAction undoAction;
    private SaveAsAction saveAsAction;
    private OpenAction openAction;
    private SaveImage saveImage;
    private SaveAction saveAction;


    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        editAction = new EditAction();
        deleteAction = new DeleteAction();
        setAuthorAction = new SetAuthorAction();
        drawRectangle = new DrawRectangle();
        elementDelete = new ElementDelete();
        elementSelect = new ElementSelect();
        elementMove = new ElementMove();
        elementZoom = new ElementZoom();

        drawLine = new DrawLine();
        chooseColor = new ChooseColor();
        chooseLineStroke = new ChooseLineStroke();
        addText = new AddText();
        saveAsAction = new SaveAsAction();
        undoAction = new UndoAction();
        redoAction= new RedoAction();
        openAction = new OpenAction();
        saveImage = new SaveImage();
        saveAction = new SaveAction();
    }


    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public SetAuthorAction getSetAuthorAction() {
        return setAuthorAction;
    }

    public DrawRectangle getDrawRectangle() {
        return drawRectangle;
    }
    public ElementDelete getElementDelete() {
        return elementDelete;
    }

    public ElementMove getElementMove() {
        return elementMove;
    }

    public ElementSelect getElementSelect() {
        return elementSelect;
    }



    public DrawLine getDrawLine() {
        return drawLine;
    }

    public void setDrawLine(DrawLine drawLine) {
        this.drawLine = drawLine;
    }

    public ChooseColor getChooseColor() {
        return chooseColor;
    }

    public ChooseLineStroke getChooseLineStroke() {
        return chooseLineStroke;
    }

    public AddText getAddText() {
        return addText;
    }

    public ElementZoom getElementZoom() {
        return elementZoom;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public SaveImage getSaveImage() {
        return saveImage;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }


}
