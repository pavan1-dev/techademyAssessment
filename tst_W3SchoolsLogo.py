import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

@pytest.fixture(scope="function")
def maindriver():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()

def tst_W3SchoolsLogo(maindriver):
    driver.get("https://www.w3schools.com/")
    logo = driver.find_element(By.ID, "w3-logo")
    assert logo.is_displayed(), "Logo is not present on the W3Schools page”
