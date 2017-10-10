const int buttonPin = 2;

void buttonPressed() {
  static unsigned long lastTime = 0;
  unsigned long interruptTime = millis();
  if (interruptTime - lastTime > 100){
    Serial.println("Interrupt");
  }
    lastTime = interruptTime;
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.
  // Three edge types are supported: CHANGE, RISING, and FALLING
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, RISING);
  Serial.begin(9600);
}
void loop() {
  for (int i = 0; i < 100; i++) {
    Serial.println(i);
    delay(1000);
  }
}
