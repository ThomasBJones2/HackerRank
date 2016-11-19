# coding: utf-8
from sklearn import svm
model = svm.SVC(kernel='linear', C=1, gamma=1)
import numpy as np
x = np.array([[-1,-1],[-2,-1],[1,1],[2,1]])
y = np.array([1,1,2,2])
model.fit(x,y)
print(model.predict([[-0.8,-1],[1,2]]))
print(model.predict([[-0.8,-1],[1,-2]]))
print(model.predict([[-0.8,-1],[-1,2]]))
get_ipython().magic(u'save simple_ml 22-30')
