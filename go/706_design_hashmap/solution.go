// https://leetcode.com/problems/design-hashmap/description/

package main

type HashItem struct {
	Key   int
	Value int
}

type MyHashMap struct {
	M [][]HashItem
}

const hashBucketNumber = 64

func Constructor() MyHashMap {
	return MyHashMap{
		M: make([][]HashItem, hashBucketNumber),
	}
}

func (this *MyHashMap) Put(key int, value int) {
	hashKey := key % 64
	bucket := this.M[hashKey]

	// we don't need to check for nil
	// other
	for i := range this.M[hashKey] {
		if this.M[hashKey][i].Key == key {
			this.M[hashKey][i].Value = value
			return
		}
	}
	this.M[hashKey] = append(bucket, HashItem{Key: key, Value: value})
}

func (this *MyHashMap) Get(key int) int {
	hashKey := key % 64
	if this.M[hashKey] != nil {
		for i := range this.M[hashKey] {
			if this.M[hashKey][i].Key == key {
				return this.M[hashKey][i].Value
			}
		}
	}

	return -1
}

func (this *MyHashMap) Remove(key int) {
	hashKey := key % 64

	if this.M[hashKey] != nil {
		for i := range this.M[hashKey] {
			if this.M[hashKey][i].Key == key {
				// add until [:i] - not inclusive
				// and add all items after i - [i+1:]... -> notice ":"
				this.M[hashKey] = append(this.M[hashKey][:i], this.M[hashKey][i+1:]...)
				return
			}
		}
	}
}
