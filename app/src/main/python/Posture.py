import pandas as pd
import numpy as np
import csv
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder, StandardScaler
import pandas as pd
import joblib

from os.path import dirname, join
def checkposture():
    file_data= pd.read_excel(join(dirname(__file__), "Labeldata.xlsx"))

    X = file_data [['X','Y','Z']].values
    Y = file_data [['Target']].values

    label_encoder = LabelEncoder()
    Y = label_encoder.fit_transform(Y)
    X = StandardScaler().fit_transform(X)

    X_train , X_test, y_train, y_test = train_test_split(X,Y,test_size=0.3, random_state=42, shuffle=True, stratify=None)

    clf = SVC(C=1.0, kernel='linear')
    clf.fit(X_train,y_train)
    ##reading file
    file_data1= pd.read_excel("/sdcard/Download/SensorData.xls")
    from sklearn import metrics



    x=file_data1[['X1','Y1','Z1']].values

    y_pred=clf.predict(x)

    print(y_pred)
    a=np.count_nonzero(y_pred == 0)
    b=np.count_nonzero(y_pred == 1)
    c=np.count_nonzero(y_pred == 2)
    d=np.count_nonzero(y_pred == 3)
    if a> max(b, c, d):
        return("You performed takbeer")
    elif b> max(a, c, d):
        return("You Performed rakuh")
    elif c> max(a, b ,d):
        return("You peform qiyam")
    elif d> max(a, b, c):
        return("You Performed Sajda")
    else:
        return("You performed noting :)")

