/**
 * The command pattern is a type of behavioral design pattern that transforms a
 * request into a stand-alone object containing all the details about the
 * request.
 * This pattern is a data-driven pattern because we make use of the information
 * about the request by
 * wrapping it as an object and is passed to the invoker object as a command.
 * The invoker object checks
 * for the object that can handle the command and passes it to that object to
 * execute the command.
 */

// Command Interface
interface Command {
    public void execute();
}

// Tubelight class
class TubeLight {
    public void lightOn() {
        System.out.println("TubeLight on...");
    }

    public void lightOff() {
        System.out.println("TubeLight off...");
    }
}

// Command class to turn on the tubelight
class TubeLightOnCommand implements Command {
    TubeLight tubeLight;

    // The constructor is passed the light it
    // is going to control.
    public TubeLightOnCommand(TubeLight tubeLight) {
        this.tubeLight = tubeLight;
    }

    public void execute() {
        tubeLight.lightOn();
    }
}

// Command class to turn off the tubelight
class TubeLightOffCommand implements Command {
    TubeLight tubeLight;

    public TubeLightOffCommand(TubeLight tubeLight) {
        this.tubeLight = tubeLight;
    }

    public void execute() {
        tubeLight.lightOff();
    }
}

// Radio class
class Radio {
    public void radioOn() {
        System.out.println("Radio on ...");
    }

    public void radioOff() {
        System.out.println("Radio off...");
    }

    public void setVolume(int volumeLevel) {
        // code to set the volume
        System.out.println("Radio volume set to " + volumeLevel);
    }
}

// Command class to turn on the radio
class RadioOnCommand implements Command {
    Radio radio;

    public RadioOnCommand(Radio radio) {
        this.radio = radio;
    }

    public void execute() {
        radio.radioOn();
    }
}

// Command class to set the volume of the radio
class RadioVolumeCommand implements Command {
    Radio radio;
    int volumeLevel;

    public RadioVolumeCommand(Radio radio, int volumeLevel) {
        this.radio = radio;
        this.volumeLevel = volumeLevel;
    }

    public void execute() {
        radio.setVolume(volumeLevel);
    }
}

// remote control with one button
class RemoteControl {
    Command button; // only one button

    public RemoteControl() {
    }

    public void setCommand(Command command) {
        // set the command the remote will
        // execute
        button = command;
    }

    public void pressButton() {
        // execute the command on click (call) of the button
        button.execute();
    }
}

// Driver class
public class CommandPatternDemo {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        TubeLight tubeLight = new TubeLight();
        Radio radio = new Radio();
        // Turn on Tubelight
        remote.setCommand(new TubeLightOnCommand(tubeLight));
        remote.pressButton();
        // Turn on Radio
        remote.setCommand(new RadioOnCommand(radio));
        remote.pressButton();
        // Turn off Radio
        remote.setCommand(new RadioVolumeCommand(radio, 4));
        remote.pressButton();
        // Turn off Tubelight
        remote.setCommand(new TubeLightOffCommand(tubeLight));
        remote.pressButton();
    }
}