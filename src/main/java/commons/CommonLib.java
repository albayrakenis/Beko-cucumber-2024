package commons;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

import static org.testng.AssertJUnit.*;


public class CommonLib extends BaseTest{


    public WebDriver myDriver;
    public WebDriverWait webDriverWait;
    private Parser parser = new Parser();
    private Page mypage;
    public int defaultTimeout = 20;



    public CommonLib(WebDriver driver) {
        myDriver = driver;

        myDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultTimeout));
        myDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(defaultTimeout));
        webDriverWait = new WebDriverWait(myDriver, Duration.ofSeconds(defaultTimeout));
    }

    public By getElementLocator(String element) {
        By returnLocator = null;
        String elementValue;
        ElementType elemType;
        Element elem = getElementFromJson(element);
        elementValue = elem.getElementValue();
        elemType = elem.getElementType();
        if (elemType != null) {
            switch (elemType.toString()) {
                case "id":
                    returnLocator = By.id(elementValue);
                    break;
                case "xpath":
                    returnLocator = By.xpath(elementValue);
                    break;
                case "className":
                    returnLocator = By.className(elementValue);
                    break;
                case "name":
                    returnLocator = By.name(elementValue);
                    break;
                case "partialLinkText":
                    returnLocator = By.partialLinkText(elementValue);
                    break;
                case "cssSelector":
                    returnLocator = By.cssSelector(elementValue);
                    break;
                case "tagName":
                    returnLocator = By.tagName(elementValue);
                    break;
            }
        }
        return (By) returnLocator;
    }

    public Element getElementFromJson(String elemName) {
        return parser.getElement(mypage.getPageName(), elemName);
    }

    public void seePage(String page) throws IOException, ParseException {
        if (parser.isPageExist(page)) {
            mypage = parser.getPageAttributes(page);

            if (mypage.getWaitElement().length() > 0) {
                waitElement(mypage.getWaitElement());
            } else {
                allureReport(StepResultType.INFO, "there is no waitElement on the page", false);
            }
        } else {

            Assert.fail(page + "page not exist in json file");
        }
    }

    public void ıGoToUrl(String url) {
        try {

           // url=ConfigurationReader.getProperty(url);

            myDriver.navigate().to(url);
            sleep(2);
            allureReport(StepResultType.PASS, "Url opened successfully", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Url could not opened successfully", true);
        }

    }

    public void sendKeys(String element, String text) {

        while (text.contains("$")) {

            text = text.replace(text.substring(text.indexOf('$'), text.indexOf("}") + 1), getElementFromGlobalVariables(text.substring(text.indexOf('$')+2, text.indexOf("}"))));

        }

        try {
            myDriver.findElement(getElementLocator(element)).sendKeys(text);
            allureReport(StepResultType.PASS, "Text send text area", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Text could not send successfully", true);
        }
    }



    public void sleep(int sec) throws InterruptedException {
        Thread.sleep(1000 * sec);
        allureReport(StepResultType.PASS, "Sleep", false);
    }

    public void clickElementWaitUntilClickable(String element)  {

//        WebElement webElementScroll = myDriver.findElement(getElementLocator(element));
//        JavascriptExecutor js = (JavascriptExecutor) myDriver;
//        js.executeScript("arguments[0].scrollIntoView();", webElementScroll);


        WebElement webElement = null;
        String style = "";
        try {
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(getElementLocator(element)));;
            style = webElement.getAttribute("style");
            highLighElement(webElement);
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }
        setDefaultStyle(style, webElement);

        webElement.click();

    }

    public void hover(String element) {
        WebElement elem =myDriver.findElement(getElementLocator(element));
        Actions actions = new Actions(myDriver);
        actions.moveToElement(elem).perform();
    }

    public void clickElementWaitUntilClickable2(String element)  {

        webDriverWait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return ((JavascriptExecutor)myDriver).executeScript("return document.readyState").equals("complete");
            }
        });


    }

    public void ıClickElement(String element) {

        WebElement webElement = null;
        String style = "";
        try {
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(getElementLocator(element)));;
            style = webElement.getAttribute("style");
            highLighElement(webElement);
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }
        setDefaultStyle(style, webElement);

        webElement.click();

    }
    public void ıAcceptOnBilgilendirmeAndSatisSozlesmesi() throws IOException, ParseException {

        try {
        System.out.println("ön bilgilendirme ve satış sözleşmesi");
        seePage("CartPage");

        WebElement onBilgilendirme  = myDriver.findElement(By.id("chk_cart_sum_confirm_1"));
        onBilgilendirme.click();

        WebElement satisSozlemesi = myDriver.findElement(By.id("chk_cart_sum_confirm_2"));
        satisSozlemesi.click();
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }
    }
    public void ıApprovedKVKK(String arg0) throws IOException, ParseException {
       seePage("ContactPage");
        WebElement kvkk = myDriver.findElement(By.xpath("//input[@id='hasKVKK']"));
        kvkk.click();
    }


    public void clickElementWaitUntilClickable(By element) {
        WebElement webElement = null;
        String style = "";
        try {
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
            style = webElement.getAttribute("style");
            highLighElement(webElement);
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }
        setDefaultStyle(style, webElement);
        webElement.click();

    }

    private void setDefaultStyle(String style, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) myDriver;
        js.executeScript("arguments[0].setAttribute('style', '" + style + "');", element);
    }

    public String getTextWithJsExecutor(String querySelector) {


        String getTextJS = "function getText() {" +
                "var text=" + querySelector + ";" +
                "return text; }; " +
                "return getText()";


        JavascriptExecutor js = (JavascriptExecutor) myDriver;
        String s = (String) js.executeScript(getTextJS);
        return s;
    }

    public void clickElement(String element) {
        try {
            myDriver.findElement(getElementLocator(element)).click();
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Could not click to element.", true);
        }


    }

    public void waitElementAndCheckVisibility(String element) {
        WebElement webElement = null;
        String style = "";
        try {
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(getElementLocator(element)));
            style = webElement.getAttribute("style");
            highLighElement(webElement);
            allureReport(StepResultType.PASS, element + " Element is found", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, element + " Element is not found", true);
        }
        setDefaultStyle(style, webElement);
    }

    public void waitElement(String element) {
        WebElement webElement = null;
        String style = "";
        try {
            webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(getElementLocator(element)));
            webElement =  myDriver.findElement(getElementLocator(element));
            style = webElement.getAttribute("style");
            highLighElement(webElement);
            allureReport(StepResultType.PASS, element +"Element is found", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, element +"Element is not found", true);
        }
        setDefaultStyle(style, webElement);
    }

    public void clickKeyboard(String element, String key) {
        WebElement elem = webDriverWait.until(ExpectedConditions.elementToBeClickable(getElementLocator(element)));

        if (key.equalsIgnoreCase("ENTER")) {
            elem.sendKeys(Keys.ENTER);
            allureReport(StepResultType.PASS, "Clicked to " + key, true);
        } else if (key.equalsIgnoreCase("TAB")) {
            elem.sendKeys(Keys.TAB);
            allureReport(StepResultType.PASS, "Clicked to " + key, true);
        }
    }

    public WebElement waitElementAndCheckVisibilityAndReturnElement(String element) {
        WebElement webElement = null;
        try {
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(getElementLocator(element)));
            allureReport(StepResultType.PASS, element + " Element is found", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, element + " Element is not found", true);
        }
        return webElement;
    }

    public boolean checkVisibilityOfElement(String element) {
        WebElement webElement = null;
        Boolean flag=false;
        try {
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(getElementLocator(element)));
            flag=true;
            allureReport(StepResultType.PASS, "'"+element + "' Element is found", true);
        } catch (Exception e) {
            allureReport(StepResultType.INFO, "'"+element + "' Element is not found", true);
        }
        return flag;
    }

    public void saveElementToGlobalVariables(String key, String value) {
        MyDriver.globalVariables.put(key, value);

    }

    public String getElementFromGlobalVariables(String key) {
        return MyDriver.globalVariables.get(key);
    }

    public void ıCheckAlertTextIsEquals(String text) {
        String alertText = myDriver.switchTo().alert().getText();
        if (alertText.equalsIgnoreCase(text)) {
            allureReport(StepResultType.PASS, "", false);
        } else {
            allureReport(StepResultType.FAIL, "text is not equal to '" + text + "'", false);
        }
    }

    public String getAlertText(){
        return myDriver.switchTo().alert().getText();
    }

    public void ıSendKeyToElementTextWithJsexecutor(String text, String elementid) {
        JavascriptExecutor js = (JavascriptExecutor) myDriver;

        System.out.println("document.getElementsById('" + elementid + "').value='" + text + "';");
        js.executeScript("document.getElementById('" + elementid + "').value='" + text + "';");
    }

    public void ıDeleteItemsOnCart() throws IOException, ParseException {
        seePage("HomePage");
        clickElementWaitUntilClickable("sepet icon");
        clickElementWaitUntilClickable("sepeti bosalt");

//        List<WebElement> elementList=myDriver.findElements(By.xpath("//*[@id=\"tbodyid\"]//a[text()=\"Delete\"]"));
//
//        for (WebElement elem:elementList) {
//            clickElementWaitUntilClickable(By.xpath("//*[@id=\"tbodyid\"]//a[text()=\"Delete\"]"));
//        }

        clickElementWaitUntilClickable("anasayfa text");
       // waitElement("categories tab");

    }

    public void highLighElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) myDriver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    public void ıCheckElementTextIsEqualWithQuerySelector(String text, String selector) {

        if (getTextWithJsExecutor(selector).equalsIgnoreCase(text)) {
            allureReport(StepResultType.PASS, "texts are equal", true);
        } else {
            allureReport(StepResultType.PASS, "texts are not equal", true);
        }
    }

    public void ıCreateAUsernameThatIsAndEndwithNumberBetweenThenSaveUsernameToGlobalvariablesAsAAndThenSignUp(String startWith, int arg1, int arg2, String username) throws InterruptedException {

        Random rnd = new Random();
        boolean flag=false;
        String tempUsername="";
        waitElement("signup modal title");
        waitElement("signup modal username label");
        waitElement("signup modal username input");
        waitElement("signup modal password label");
        waitElement("signup modal password input");
        waitElement("signup modal close button");
        waitElement("signup modal signup button");
        while(!flag){
            tempUsername = startWith + "" + (arg1 + rnd.nextInt(arg2));
            sendKeys("signup modal username input",tempUsername);
            sendKeys("signup modal password input","123");
            clickElementWaitUntilClickable("signup modal signup button");
            sleep(5);
            if(getAlertText().equalsIgnoreCase("Sign up successful.")){
                ıCheckAlertTextIsEquals("Sign up successful.");
                myDriver.switchTo().alert().accept();
                saveElementToGlobalVariables(username,tempUsername);
                flag=true;
            }else if(getAlertText().equalsIgnoreCase("This user already exist.")){
                ıCheckAlertTextIsEquals("This user already exist.");
                myDriver.switchTo().alert().accept();
                waitElementAndCheckVisibilityAndReturnElement("signup modal username input").clear();
                waitElementAndCheckVisibilityAndReturnElement("signup modal password input").clear();
            }
        }
        if(checkVisibilityOfElement("signup modal close button")){
            clickElementWaitUntilClickable("signup modal close button");
        }
    }


    public void ıCreateAAdressThatIsStartAndEndWithNumberBetween(String startWith, int arg1, int arg2) throws InterruptedException {

        Random rnd = new Random();
        boolean flag=false;
        String tempUsername="";
        waitElement("Adres Adi");

            tempUsername = startWith + " " + (arg1 + rnd.nextInt(arg2));
            sendKeys("Adres Adi",tempUsername);

    }

    public void ıCreateAMailThatIsStartAndEndWith(String kullaniciAdi, String uzanti) {
        Random rnd = new Random();
        boolean flag=false;
        String tempUsername="";
        waitElement("Guest email");

        tempUsername = kullaniciAdi+rnd.nextInt(10000)+uzanti;
        sendKeys("Guest email",tempUsername);

        allureReport(StepResultType.PASS, "'"+kullaniciAdi + "' oluşturuldu", true);
    }

    public void ıChooseCityFromList(String City){


        Select select = new Select( myDriver.findElement(By.id("cityCode")));
        select.selectByVisibleText(City);

        allureReport(StepResultType.PASS, "'"+City + "' Element is found", true);

    }

    public void ıChooseTownFromList(String Town) {
        Select select = new Select( myDriver.findElement(By.id("townCode")));
        select.selectByVisibleText(Town);
        allureReport(StepResultType.PASS, "'"+Town + "' Element is found", true);
    }

    public void ıChooseNeighborhoodFromList(String Neighborhood) {
        Select select = new Select( myDriver.findElement(By.id("neighborhood")));
        select.selectByVisibleText(Neighborhood);

        allureReport(StepResultType.PASS, "'"+Neighborhood + "' Element is found", true);
    }

    public void ıChooseTaxCityFromList(String TaxCity) {
        Select select = new Select( myDriver.findElement(By.id("taxOffice")));
        select.selectByVisibleText(TaxCity);
        allureReport(StepResultType.PASS, "'"+TaxCity + "' Element is found", true);
    }

    public void ıChooseCityAndTownFromFastDeliveryList(String il, String ilce) {
        Select select = new Select( myDriver.findElement(By.cssSelector(".js-form-delivery-store #cityCode")));

        select.selectByVisibleText(il);
        allureReport(StepResultType.PASS, "'"+il + "' Element is found", true);

        Select select2 = new Select( myDriver.findElement(By.cssSelector(".js-form-delivery-store #townCode")));

        select2.selectByVisibleText(ilce);
        allureReport(StepResultType.PASS, "'"+ilce + "' Element is found", true);
    }


    public void ıChooseCityFromListForClickAndCollect(String City) {
        Select select = new Select( myDriver.findElement(By.cssSelector(".js-click-collect-store #cityCode")));

        select.selectByVisibleText(City);
        allureReport(StepResultType.PASS, "'"+City + "' Element is found", true);

    }

    public void ıChooseTownFromListForClickAndCollect(String town) {
        Select select = new Select( myDriver.findElement(By.cssSelector(".js-click-collect-store #townCode")));

        select.selectByVisibleText(town);
        allureReport(StepResultType.PASS, "'"+town + "' Element is found", true);

    }

    public void ıWaitUntilElementToBeClickableAndClickToElementIfElementExist(String element, int timeout) {

        try {


            WebDriverWait wait = new WebDriverWait(myDriver,Duration.ofSeconds(timeout));

//            String element2 = String.valueOf(wait.until(ExpectedConditions.visibilityOfElementLocated(getElementLocator(element))));
            myDriver.findElement(getElementLocator(element)).click();
//            clickElement(element2);
            System.out.println("element bulundu");
            allureReport(StepResultType.PASS, "Clicked to element.", true);
        }catch (Exception e){
            allureReport(StepResultType.INFO,element +"" +element,Boolean.FALSE);
            System.out.println("2");
        }

    }

    public void ıClearTextbox(String arg0) {
        WebElement myelem = myDriver.findElement(getElementLocator(arg0));
        try {
            myelem.clear();
            allureReport(StepResultType.PASS,arg0 + "text is cleared", true);

        }catch (Exception e){
            allureReport(StepResultType.FAIL,arg0 + "text is not cleared", true);
        }
    }

    public void ıSendKeyToElementRandomName(String arg0) {
        Faker faker = new Faker();
        String name="";

        name=faker.name().firstName();
    }

    public String ıSendKeyToElementRandom(String locater, String keys) {
        Faker faker = new Faker();
        allureReport(StepResultType.PASS, "Send to keys", false);


        if (keys != null) {
            switch (keys) {
                case "name":
                    keys = faker.name().firstName();
                    sendKeys(locater,keys);
                    System.out.println(keys);
                    break;
                case "surname":
                    keys = faker.name().lastName();
                    sendKeys(locater,keys);
                    System.out.println(keys);
                    break;
                case "fullname":
                    keys = faker.name().fullName();
                    sendKeys(locater,keys);
                    System.out.println(keys);
                    break;
                case "adress":
                    keys = faker.address().fullAddress();
                    sendKeys(locater,keys);
                    System.out.println(keys);
                    break;
                case "adress name":
                    keys = faker.address().country()+" "+ faker.address().cityName()+faker.number();
                    sendKeys(locater,keys);
                    System.out.println(keys);
                    break;
                case "phone number":
                    int nums =75;
                    keys = nums+ String.valueOf(faker.number().numberBetween(1000000,99999999));
                    sendKeys(locater,keys);
                    System.out.println(keys);
                    break;

            }

            locater=myDriver.findElement(getElementLocator(locater)).getAttribute("value");
            Assert.assertEquals(locater,keys);
            System.out.println(locater);
            allureReport(StepResultType.PASS, "Degistirilen bilgi güncellendi", false);
        }
        return keys;



    }

    public void ıScrollAndClickToElementWithJavascript(String element) {
        try {
            //Locating element by link text and store in variable "Element"
            WebElement webElement = myDriver.findElement(getElementLocator(element));
            JavascriptExecutor js = (JavascriptExecutor) myDriver;
            // Scrolling down the page till the element is found
            js.executeScript("arguments[0].scrollIntoView();", webElement);
            waitElement(element);
//            js.executeScript("arguments[0].click();", element);
//            allureReport(StepResultType.PASS, "'"+element + "' Element is found and click", true);
        }catch (Exception e){
            allureReport(StepResultType.FAIL,element + "element is not clicable", true);
        }
    }




    public void ıDeleteSavedAdress() throws IOException, ParseException, InterruptedException {
        seePage("HesabimPage");


        List<WebElement> elementList=myDriver.findElements(By.xpath("//a[@data-bdy='msg-opened']"));

        if(elementList.size()>3) {
            int son = elementList.size() - 3;
            for (int i = 0; i < son; i++) {
                clickElementWaitUntilClickable(By.xpath("//div[@class='usr-addresses']/div[1]//a[contains(.,'Sil')]"));
                clickElementWaitUntilClickable(By.xpath("//button[@class='btn btn-outline-dark btn-small js-popup-trigger-func']"));
                sleep(3);
            }
        }else {
            System.out.println("yeteri kadar adres yok");
        }



    }

    public void ıScrollUntilFindElementWithAction(String element)  {

        try {
            WebElement webElement = myDriver.findElement(getElementLocator(element));
            Actions actions = new Actions(myDriver);
            actions.scrollToElement(webElement).perform();
            Allure.addAttachment("ScreenShot: Elemente scroll edildi" ,new ByteArrayInputStream(((TakesScreenshot) myDriver).getScreenshotAs(OutputType.BYTES)));
        }catch (Exception e){

            System.out.println("element bulunamadı");
        }

    }


    public void allureReport(StepResultType result, String message, boolean ssFlag) {
        try {
            System.out.println(message);
            if (ssFlag) {
                Allure.addAttachment("ScreenShot: " + message, new ByteArrayInputStream(((TakesScreenshot) myDriver).getScreenshotAs(OutputType.BYTES)));
            }

            if (result.toString().equalsIgnoreCase("PASS")) {
                Allure.step(message, Status.PASSED);
            } else if (result.toString().equalsIgnoreCase("INFO")) {
                Allure.step(message, Status.SKIPPED);
            } else if (result.toString().equalsIgnoreCase("FAIL")) {
                Allure.step(message, Status.FAILED);
                Assert.fail(message);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(">>>>>>>>>>>ERROR:CHECK FUNCTION(allureReport)<<<<<<<<<<");
        }
    }

    public void ıChangeTheFrame() {
        WebElement element = myDriver.findElement(By.cssSelector("iframe[title='Beraber Se\u00E7elim ANASAYFA']"));;
        myDriver.switchTo().frame(element);
    }


    public void ıClickElementAndSaveTheFile(String kategori, String dosyaAdi) throws InterruptedException {




        WebDriverWait wait = new WebDriverWait(myDriver, Duration.ofSeconds(10));
        List<String> list_of_image_error = new ArrayList<>();
        myDriver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        allureReport(StepResultType.PASS, "cerezler kabul edildi.", true);

        Thread.sleep(2000);

        try {

            Thread.sleep(2000);
            myDriver.findElement(By.xpath("//button[@data-target='#main-menu']")).click();

            allureReport(StepResultType.PASS, "Urunler butonuna tiklandi.", true);

            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[.='"+kategori+"'])[1]"))).click();
            allureReport(StepResultType.PASS, "Kategori butonuna tiklandi.", true);
            Thread.sleep(2000);
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='lv1-li selected']//li[@class='lv2-li no-sub']/a[.='Tüm Ürünler']"))).click();

            WebElement count = myDriver.findElement(By.cssSelector("b"));
            System.out.println("-------------------------------------------------------------------");
            String countStr = count.getText();
            int number =Integer.parseInt(countStr);
            int a=number/20;
            Thread.sleep(2000);

            for (int i = 0; i <= a; i++) {
                WebElement element = myDriver.findElement(By.xpath("//footer[@id='site-footer']"));
                ((JavascriptExecutor) myDriver).executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});", element
                );
                allureReport(StepResultType.PASS, "1 sayfa asagi kaydirildi.", true);
                Thread.sleep(2500); // Kaydırmalar arasında bekleme
            }

            List<WebElement> urunler = myDriver.findElements(By.xpath("//div[@class='products productgridcomponent-page']/article"));
            for (WebElement urun : urunler) {
                try {
                    // Ürünün img elementini bul
                    WebElement resim = urun.findElement(By.cssSelector("img"));
                    String src = resim.getAttribute("src"); // Görselin 'src' özelliği
                    String imgClass = resim.getAttribute("class"); // Görselin 'class' özelliği

                    // Görsel yok veya hatalı ise kaydet
                    if (src == null || src.isEmpty() || src.equals("null") ||
                            (imgClass != null && imgClass.contains("lazy error"))) {
                        list_of_image_error.add(urun.getAttribute("data-config"));
                    }

                } catch (NoSuchElementException e) {
                    // Görsel bulunamazsa ürün bilgisi listeye eklenir
                    list_of_image_error.add(urun.getAttribute("data-config"));
                }
            }

            // Hatalı görselleri dosyaya yazdır

            try (FileWriter writer = new FileWriter("C:\\Users\\MONSTER\\OneDrive\\Desktop\\gorsel sonuclari\\"+dosyaAdi+".txt")) {
            //try (FileWriter writer = new FileWriter("C:\\Users\\MONSTER\\OneDrive\\Desktop\\gorsel sonuclari\\a.txt")) {
                for (String error : list_of_image_error) {
                    writer.write(error + System.lineSeparator());
                }
            }
//            try (FileWriter successWriter = new FileWriter("C:\\Users\\MONSTER\\OneDrive\\Desktop\\gorsel sonuclari\\tumSonuclar.txt")) {
//                for (String success : list_of_image_error) {
//                    successWriter.write(success + System.lineSeparator());
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Tarayıcıyı kapat
            myDriver.quit();
        }




        System.out.println("Test tamamlandı.");


    }

    public void brokenLinksCheck() {

        String[] categories = {"/beyaz-esya", "/ankastre", "/televizyon", "/elektronik", "/isitma-sogutma", "/kucuk-ev-aletleri", "/hijyen-aksesuar", "/arcelik-enerji-cozumleri", "/temizlik-ve-bakim-urunleri", "/su-aritma"};
        String[] fileNames = {"beyaz-esya", "ankastre", "televizyon", "elektronik", "isitma-sogutma", "kucuk-ev-aletleri", "hijyen-aksesuar", "arcelik-enerji-cozumleri", "temizlik-ve-bakim-urunleri", "su-aritma"};

        try {
            setupDriver();
            for (int j = 0; j < categories.length; j++) {
                myDriver.findElement(By.xpath("//button[@data-target='#main-menu']")).click();
                Thread.sleep(3000);

                Actions actions = new Actions(myDriver);
                WebElement categoryElement = myDriver.findElement(By.xpath("//a[@href='" + categories[j] + "']"));
                actions.moveToElement(categoryElement).perform();
                Thread.sleep(1000);
                myDriver.findElement(By.xpath("//li[@class='lv1-li selected']//a[@title='Tüm Ürünler']")).click();
                waitForPageLoad();

                for (int k = 0; k < 8; k++) {
                    WebElement footerElement = myDriver.findElement(By.xpath("//footer[@id='site-footer']"));
                    ((JavascriptExecutor) myDriver).executeScript("arguments[0].scrollIntoView({block: 'center'});", footerElement);
                    Thread.sleep(3500);
                }

                List<WebElement> productLinks = myDriver.findElements(By.xpath("//div[@class='products productgridcomponent-page']//a"));
                List<String> listOK = new ArrayList<>();
                List<String> listNotFound = new ArrayList<>();

                for (WebElement linkElement : productLinks) {
                    String href = linkElement.getAttribute("href");

                    if (isValidURL(href)) {
                        int responseCode = getHttpResponseCode(href);
                        if (responseCode == 200) {
                            listOK.add(href);
                        } else {
                            listNotFound.add(href);
                        }
                    } else {
                        listNotFound.add(href);
                    }
                }

                writeToFile("product_OK_" + fileNames[j] + ".txt", listOK);
                writeToFile("product_notfound_" + fileNames[j] + ".txt", listNotFound);
            }


            System.out.println("Test Passed!");
        } catch (Exception e) {

            System.err.println("Test Failed: " + e.getMessage());
        }
    }

    private void setupDriver() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
 //       myDriver = new ChromeDriver(options);
    }

    private void waitForPageLoad() {
        new WebDriverWait(myDriver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int getHttpResponseCode(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            return -1;
        }
    }







    //----------------------------------------------------------------

    /*public void brokenLinksCheckCategoriesAndFileNames(String kategori, String dosyaAdi) {
        try {
            WebDriverWait wait = new WebDriverWait(myDriver, Duration.ofSeconds(10));

            // Cookie banner'ı kabul et
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@id='onetrust-accept-btn-handler']"))).click();

            // Ana menüyü aç
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@data-target='#main-menu']"))).click();

            // Kategori seçimi
            Actions actions = new Actions(myDriver);
            WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//a[@href='" + kategori + "'])[1]")));
            actions.moveToElement(categoryElement).perform();

            // Tüm ürünlere tıkla
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//li[@class='lv1-li selected']//a[@title='Tüm Ürünler']"))).click();

            // Sayfa yüklenene kadar bekle
            waitForPageLoad();

            // Dinamik scroll işlemi
            scrollToLoadAllProducts();

            // Ürün linklerini topla
            List<WebElement> productLinks = myDriver.findElements(
                    By.xpath("//div[@class='products productgridcomponent-page']//a"));

            List<String> listOK = new ArrayList<>();
            List<String> listNotFound = new ArrayList<>();

            // Link kontrolü
            checkLinks(productLinks, listOK, listNotFound);

            // Sonuçları kaydet
            String baseDir = System.getProperty("user.dir");
            String resultDir = baseDir + "/test-results";
            new File(resultDir).mkdirs();

            writeToFile(resultDir + "/valid_links.txt", listOK);
            writeToFile(resultDir + "/broken_links.txt", listNotFound);

            log.info("Test başarıyla tamamlandı. Bulunan linkler: OK={}, NotFound={}",
                    listOK.size(), listNotFound.size());

        } catch (TimeoutException e) {
            log.error("Element bekleme zaman aşımı: {}", e.getMessage());
            throw e;
        } catch (ElementClickInterceptedException e) {
            log.error("Element tıklanamadı (intercepted): {}", e.getMessage());
            throw e;
        } catch (IOException e) {
            log.error("Dosya işlemleri hatası: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Beklenmeyen hata: {}", e.getMessage());
            throw e;
        }
    }
*/
    private void scrollToLoadAllProducts() {
        JavascriptExecutor js = (JavascriptExecutor) myDriver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            WebElement footer = myDriver.findElement(By.xpath("//footer[@id='site-footer']"));
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", footer);

            // Yeni içeriğin yüklenmesi için bekle
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
    }

    private void checkLinks(List<WebElement> links, List<String> validLinks, List<String> brokenLinks) {
        links.parallelStream().forEach(linkElement -> {
            String href = linkElement.getAttribute("href");
            if (isValidURL(href)) {
                int responseCode = getHttpResponseCode(href);
                synchronized (validLinks) {
                    if (responseCode == 200) {
                        validLinks.add(href);
                    } else {
                        brokenLinks.add(href + " (Status: " + responseCode + ")");
                    }
                }
            } else {
                synchronized (brokenLinks) {
                    brokenLinks.add(href + " (Invalid URL)");
                }
            }
        });
    }
    public void writeToFile(String fileName, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\MONSTER\\OneDrive\\Desktop\\gorsel sonuclari\\404Check.txt"))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
        }
    }

    public void ıLoginWithAnd(String username, String sifre) {
       username =ConfigurationReader.getProperty(username);
       sifre =ConfigurationReader.getProperty("sifre");
        try{
        waitElement("username");
        waitElement("password");

        sendKeys("username", username);
        sendKeys("password", sifre);
        allureReport(StepResultType.PASS, "Url opened successfully", true);
    } catch (Exception e) {
        allureReport(StepResultType.FAIL, "Url could not opened successfully", true);
    }


    }

    public void ıLoginWithAndCanli(String username, String sifre) {


       username =ConfigurationReader.getProperty("kullaniciCanli");
       sifre =ConfigurationReader.getProperty("sifre");
        try{
        waitElement("username");
        waitElement("password");

        sendKeys("username", username);
        sendKeys("password", sifre);
        allureReport(StepResultType.PASS, "Url opened successfully", true);
    } catch (Exception e) {
        allureReport(StepResultType.FAIL, "Url could not opened successfully", true);
    }


    }

    public void ıGoToWithConfiguration(String url) {

        try {

            url=ConfigurationReader.getProperty(url);

            myDriver.navigate().to(url);
            sleep(2);
            allureReport(StepResultType.PASS, "Url opened successfully", true);
        } catch (Exception e) {
            allureReport(StepResultType.FAIL, "Url could not opened successfully", true);
        }

    }

    public void ıHoverHeaderAndClickCategory(String header, String category) throws IOException, ParseException {
        Actions actions = new Actions(myDriver);

        WebElement myelem = myDriver.findElement(getElementLocator(header));
        WebElement myelem2 = myDriver.findElement(getElementLocator(category));
        try {
            actions.moveToElement(myelem).perform();
            myelem2.click();
            allureReport(StepResultType.PASS,header + category+ "sayfasina gidildi", true);

        }catch (Exception e){
            allureReport(StepResultType.FAIL,header + category+ "sayfasina gidilemedi", true);
        }
    }

    private WebDriver driver;
    private List<String> allLinks;
    private List<String> brokenLinks;

    public void ıAmOnTheHomepage() {
        myDriver.get("https://www.beko.com.tr");
        // Gerekirse cookie banner'ı kabul et
        WebDriverWait wait = new WebDriverWait(myDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
    }

    public void ıCollectAllLinksFromTheWebsite() {
        allLinks = new ArrayList<>();
        List<WebElement> linkElements = myDriver.findElements(By.tagName("a"));
        for (WebElement element : linkElements) {
            String link = element.getAttribute("href");
            if (link != null && !link.isEmpty() && link.startsWith("http")) {
                allLinks.add(link);
            }
        }
    }

    public void ıCheckEachLinkForErrors(int arg0) {
        brokenLinks = new ArrayList<>();
        for (String link : allLinks) {
            try {
                URL url = new URL(link);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 404) {
                    brokenLinks.add(link);
                }
            } catch (Exception e) {
                brokenLinks.add(link + " - Exception: " + e.getMessage());
            }
        }
    }

    public void ıShouldSeeAReportOfLinksWithErrors(int arg0) {
        System.out.println("Total links checked: " + allLinks.size());
        System.out.println("Broken links found: " + brokenLinks.size());
        for (String link : brokenLinks) {
            System.out.println("Broken link: " + link);
        }
        // Opsiyonel: Sonuçları bir dosyaya yazabilirsiniz
         writeToFile("broken_links_report.txt", brokenLinks);
    }

    private void writeToFile2(String fileName, List<String> content) {
        String baseDir = System.getProperty("user.dir");
        String filePath = baseDir + "/test-results/" + fileName;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (String line : content) {
                writer.println(line);
            }
            System.out.println("Results written to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void ıCheckElementCountIsEqualWithXpath(String arg0, String arg1) {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement articleLengthElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='article-length']")));

        WebElement articleLengthElement =myDriver.findElement(By.xpath("//span[@id='article-length']"));
        // Elementin text'ini al
        String articleLengthText = articleLengthElement.getText().trim();

        // Text'i integer'a çevir
        int articleLength = Integer.parseInt(articleLengthText);


        // Kontrol et

        assertEquals(0, articleLength);
    }

    public void ıCheckElementCountIsGreaterThanWithXpath(String arg0, String arg1) {
        WebElement articleLengthElement =myDriver.findElement(By.cssSelector(arg1));
        // Elementin text'ini al
        String articleLengthText = articleLengthElement.getText().trim();

        // Text'i integer'a çevir
        int articleLength = Integer.parseInt(articleLengthText);


        // Kontrol et

        assertTrue(  articleLength>0);

    }


    public void switchToNewTabAndVerifyTitle() {
        String originalWindow = myDriver.getWindowHandle();


        // Tüm pencere tanıtıcılarını al
        Set<String> windowHandles = myDriver.getWindowHandles();

        // Yeni pencereye geç
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                myDriver.switchTo().window(handle);
                break;
            }
        }

    }


}

