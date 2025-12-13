package services;

class SMSSender implements MessageSender{
    public void sendSMS(String to, String message) // to is mobile number
    {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}
