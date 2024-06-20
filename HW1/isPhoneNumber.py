import re

def isPhoneNumber(text):
    phone_pattern = r'[0-9]{3}-\d{3}-\d{4}'
    return bool(re.search(phone_pattern, text))

if __name__ == "__main__":
    print(str(isPhoneNumber("123-456-7890")))  # TRUE
    print(str(isPhoneNumber("This has a number 450-213-4221")))  # TRUE 
    print(str(isPhoneNumber("123-421-542a")))  # FALSE
